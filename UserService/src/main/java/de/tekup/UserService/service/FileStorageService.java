package de.tekup.UserService.service;

import de.tekup.UserService.models.FileStorageException;
import de.tekup.UserService.models.FileStorageProperties;
import de.tekup.UserService.models.MyFileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileStorageService {
    Path path = Paths.get("c:\\data\\");
    //add file path to download from:
    Path downloadPath = Paths.get("C:\\Users\\Asus\\Downloads\\ProjectStagi\\Stage\\stagi.tn\\src\\assets\\img\\pdp\\");
    //private final Path fileStorageLocation;

    //private final Path fileStorageLocation;
/*
    @Autowired
    public FileStorageService(FileStorageProperties fileStorageProperties) {
        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
                .toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
        }
    }
*/
    public String storeFile(MultipartFile file, String userId) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }
            // set storage location with file name
            // determining file type from userID
            // important ADD CV Link to cv Field to only have one cv file and
            // to make it easier to manage
            /*if(userId.equals("image")){
                fileName = "C:\\AK\\"+fileName;
            }else fileName = "C:\\AK\\"+fileName;//+".pdf";*/
            // machine Dali
            //fileName="C:\\Users\\boual\\Desktop\\Cii-3\\Projet Stagi\\stagi\\stagi.tn\\src\\assets\\img\\pdp\\"+fileName;
            // Machine Ahdy
            //fileName = "C:\\Users\\Asus\\Downloads\\ProjectStagi\\Stage\\stagi.tn\\src\\assets\\img\\pdp\\"+fileName;
            // EC2
            fileName = "/home/ec2-user/stage/Stage/stagi.tn/src/assets/img/pdp/"+fileName;
            // Copy file to the target location (Replacing existing file with the same name)
            //Path targetLocation = this.fileStorageLocation.resolve(fileName);
            Path targetLocation = this.path.resolve(fileName);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }
    // Delete the file:
    public String deleteFile( String filepath) {
        // Normalize file name
        String fileName = filepath;

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            fileName = "C:\\Users\\Asus\\Downloads\\ProjectStagi\\Stage\\stagi.tn\\src\\assets\\img\\pdp\\"+fileName;

            Path targetLocation = this.path.resolve(fileName);
            Files.delete(targetLocation);
            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not find file " + fileName + ".these is the error", ex);
        }
    }

    // Download a File:
    public Resource loadFileAsResource(String fileName) {
        try {
            //Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
             Path filePath = this.downloadPath.resolve(fileName);
            //Path filePath = this.path.resolve(fileName);
            Resource resource = new UrlResource(filePath.toUri());
            System.out.println("filePath: formLoadFile"+filePath.toString());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }
/*
    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                throw new MyFileNotFoundException("File not found " + fileName);
            }
        } catch (MalformedURLException ex) {
            throw new MyFileNotFoundException("File not found " + fileName, ex);
        }
    }*/
}
