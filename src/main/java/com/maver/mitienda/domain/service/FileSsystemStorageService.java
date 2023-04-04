package com.maver.mitienda.domain.service;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileSsystemStorageService
{
    public String store(MultipartFile file)
    {
        String originalFilename = file.getOriginalFilename();//obtenemos el nombre del archivo
        String filename = UUID.randomUUID()+"_"+ StringUtils.getFilenameExtension(originalFilename);
                                                                    //generamos un nombre unico para el archivo
        if (file.isEmpty())//si el archivo esta vacio
        {
            throw  new RuntimeException("No se puede almacenar un archivo vacio : "+originalFilename);//una excepcion
        }

        try
        {
            InputStream inputStream = file.getInputStream();
            Files.copy(inputStream, Paths.get("mediafiles").resolve(filename), StandardCopyOption.REPLACE_EXISTING);
                                                                            //copiamos el archivo a la ruta especificada

        }catch (IOException exception)//si existe un error
        {
            throw new RuntimeException("No se pudo almacenar el archivo: "+originalFilename,exception);
        }

        return filename;
    }

    public Resource loadAsResource(String filename)
    {
        try
        {
            Path path = Paths.get("mediafiles").resolve(filename);
            Resource resource = new UrlResource(path.toUri());

            if (resource.exists() || resource.isReadable())
            {
                return resource;
            }
            else
            {
                throw new RuntimeException("No se pudo cargar el archivo: "+filename);
            }
        }catch (MalformedURLException exception)
        {
                throw new RuntimeException("No se pudo cargar el archivo: "+filename,exception);
        }
    }

    public void delete(String filename)
    {
        Path path = Paths.get("mediafiles").resolve(filename);

        try
        {
            FileSystemUtils.deleteRecursively(path);
        }catch (Exception exception)
        {

        }



    }
}
