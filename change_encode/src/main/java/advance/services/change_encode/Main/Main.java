/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advance.services.change_encode.Main;

import advance.services.change_encode.common.Resources;
import java.io.FileNotFoundException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import javax.xml.XMLConstants;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author kapar
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException, ParserConfigurationException, IOException {

        ArrayList<String> files = listoffiles(Resources.WORKING_FOLDER_PATH);
        for (String file : files) {
            String content = FileUtils.readFileToString(new File(file), Resources.ENCODING_Cp1252);
            FileUtils.write(new File(file), content, Resources.ENCODING_UTF_8);
        }

    }

    public static ArrayList<String> listoffiles(String path) {
        File directoryPath = new File(path);
        File filesList[] = directoryPath.listFiles();
        ArrayList<String> list = new ArrayList<>();
        for (File file : filesList) {
            list.add(file.getAbsolutePath());
            System.out.println("File path: " + file.getAbsolutePath());
        }
        return list;
    }

}
