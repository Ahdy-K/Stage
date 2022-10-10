package de.tekup.entreprise_service.filter;


import de.tekup.entreprise_service.services.EntrepriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
@CrossOrigin(origins ="*")
public class CustomAuthorisationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;


    public CustomAuthorisationFilter(JwtUtil jwtUtil, EntrepriseService entrepriseService) {
        this.jwtUtil = jwtUtil;
        this.entrepriseService = entrepriseService;
    }

    @Autowired
    private EntrepriseService entrepriseService;
    @Override
    @CrossOrigin(origins ="*")
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

            String authorizationHeader=request.getHeader(AUTHORIZATION);

            String username=null;
            String token=null;

            if(authorizationHeader!=null&& authorizationHeader.startsWith("Bearer ")) {

                token = authorizationHeader.substring("Bearer ".length());
                System.out.println(token);
                username = jwtUtil.extractUsername(token);
                System.out.println(username);
            }

                    if(username!=null&& SecurityContextHolder.getContext().getAuthentication()==null) {
                        UserDetails userDetails= this.entrepriseService.loadUserByUsername(username);

                        if(jwtUtil.validateToken(token,userDetails)){
                            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                            SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                        }else {
                            filterChain.doFilter(request,response);
                        }


                    }
                    filterChain.doFilter(request,response);



        }


}
