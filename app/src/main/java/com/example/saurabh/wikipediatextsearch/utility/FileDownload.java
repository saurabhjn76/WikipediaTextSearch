package com.example.saurabh.wikipediatextsearch.utility;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class FileDownload {

public static void saveFileFromUrl(String fileName, String fileUrl)
 throws MalformedURLException, IOException {
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        try {
        in = new BufferedInputStream(new URL(fileUrl).openStream());
        fout = new FileOutputStream(fileName);

       byte data[] = new byte[1024];
        int count;
        while ((count = in.read(data, 0, 1024)) != -1) {
        fout.write(data, 0, count);
        }
        } finally {
        if (in != null)
        in.close();
        if (fout != null)
        fout.close();
    }
 }
}