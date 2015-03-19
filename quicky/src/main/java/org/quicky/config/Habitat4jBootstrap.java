/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.quicky.config;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.productivity.java.habitat4j.Habitat4JBootstrap;
import org.productivity.java.habitat4j.PropertyListManager;
import org.productivity.java.habitat4j.ServerIdentityManager;
import org.productivity.java.habitat4j.common.Habitat4JConstants;
import org.productivity.java.habitat4j.common.Habitat4JFeatures;
import org.productivity.java.habitat4j.common.PropertyHash;
import org.productivity.java.habitat4j.common.exception.PropertyListHandlerException;

/**
 *
 * @author Emmanuel
 */
public class Habitat4jBootstrap {
    // google search --> "extending PropertyPlaceholderConfigurer"
    //result --> http://robertmaldon.blogspot.com/2007/06/extending-spring-propertyplaceholdercon.html
	
    private static final String SERVER_IDENTITY_FILE = "/server-identity.xml";
    public static final String DEFAULT_FILE_SEPARATOR = "/";
    public static final String BOOTSTRAP_APP_NAME = "PCRCP";

    // Main property file for the PCR application
    // Add more property file as needed but remember to load it 
    // in the initialize() method
    public static final String PCRCP_PROP_LKUP_DEFAULT_PATH = "/property.xml";


    public static final String PCRCP_PROPERTY_LIST_NAME = "PCRCPPropLkup";

    // The "server-identity.xml" file will be searched for in these directories. 
    // First one to match is the one that loads.
    public static final String[] BOOTSTRAP_SERVER_IDENTITY_DIRS = new String[]{"C:/Users/U329022/Desktop/properties"};

    // The "AppPropLkup.xml" or any other property file will be searched for in these directories. 
    // First one to match is the one that loads.
    public static final String[] PROPERTY_FILES_DIRS = new String[]{"C:/Users/U329022/Desktop/properties"};

    static {
        initialize();
    }

    private static void initialize() {
        try {
            ServerIdentityManager.reset();
            PropertyListManager.reset();

            String serverIdentityFile = SERVER_IDENTITY_FILE;
            String serverIdentityPath = Habitat4JBootstrap.createServerIdentityPath(serverIdentityFile, BOOTSTRAP_SERVER_IDENTITY_DIRS);
            System.setProperty(Habitat4JConstants.HABITAT4J_SAX_DRIVER_SYSTEM_PROPERTY_NAME, "org.apache.xerces.parsers.SAXParser");
            PropertyListManager.initialize(BOOTSTRAP_APP_NAME);
            System.setProperty(Habitat4JConstants.HABITAT4J_SERVER_IDENTITY_FILE_PATH_SYSTEM_PROPERTY_NAME, serverIdentityPath);
            PropertyListManager.setFeature(Habitat4JFeatures.PROPERTY_LIST_FEATURE_SUPPRESS_PROPERTY_BEAN_COPY_WARNINGS, true);
            PropertyListManager.setFeature(Habitat4JFeatures.PROPERTY_LIST_FEATURE_DATE_RELOAD, true);
            PropertyListManager.setFeature(Habitat4JFeatures.PROPERTY_LIST_FEATURE_DATE_RELOAD_ON_THE_FLY, true);
            PropertyListManager.reloadOnFileChange();
            PropertyListManager.loadPropertyListFromFile(createPropertyFilePath(PCRCP_PROP_LKUP_DEFAULT_PATH, PROPERTY_FILES_DIRS));

        } catch (PropertyListHandlerException plhe) {
            //usage();
            throw new RuntimeException(plhe.toString());
        }
    }

    /**
     *
     * @param hashName
     * @param key
     * @return
     */
    public static String getProperty(String hashName, String key) {
        return PropertyListManager.getPropertyHashValue("PCRCPPropLkup", hashName, key);
    }

    /**
     *
     * @param hashName
     * @param key
     * @return
     */
    public static String getTestProperty(String hashName, String key) {
        return PropertyListManager.getPropertyHashValue("TESTPropLkup", hashName, key);
    }

    /**
     *
     * @param propertyListName
     * @param name
     * @return
     */
    public static PropertyHash getPropertyHash(String propertyListName, String name) {
        return PropertyListManager.getPropertyHash(propertyListName, name);
    }

    /**
     *
     * @param propertyFileName
     * @param directories
     * @return
     */
    private static String createPropertyFilePath(String propertyFileName, String[] directories) {
        String _propertyFileName = propertyFileName;
        File propertyPath = null;

        if (_propertyFileName == null || _propertyFileName.trim().equals("")) {
            _propertyFileName = PCRCP_PROP_LKUP_DEFAULT_PATH;
        }

        if (directories == null || directories.length < 1) {
            return _propertyFileName;
        }

        if (_propertyFileName.charAt(0) == '/' || _propertyFileName.charAt(0) == '\\') {
            _propertyFileName = _propertyFileName.substring(1);
        }

        StringBuilder path = new StringBuilder();
        String separator = System.getProperty("file.separator");
        if (separator == null || separator.equals("")) {
            separator = DEFAULT_FILE_SEPARATOR;
        }

        for (int i = 0; i < directories.length; i++) {
            path.setLength(0);
            path.append(directories[i]);
            path.append(separator);
            path.append(_propertyFileName);

            propertyPath = new File(path.toString());
            if (propertyPath.exists() && propertyPath.canRead()) {
                break;
            }
        }
        return path.toString();
    }


    /**
     * @param args the command line arguments
     * @throws org.productivity.java.habitat4j.common.exception.PropertyListHandlerException
     */
    public static void main(String[] args) throws PropertyListHandlerException {

        String value = Habitat4jBootstrap.getProperty("spanish", "1");
        System.out.println(value);
        //System.out.println(PropertyListManager.getPropertyList("PCRCPPropLkup"));
        //System.out.println(PropertyListManager.getPropertyHash("PCRCPPropLkup", "english"));
        Properties props = new Properties();
        Enumeration enumer = PropertyListManager.getPropertyList("PCRCPPropLkup").getProperties();
        Map<String, Properties> bigMap = new HashMap();
        while(enumer.hasMoreElements()){
            String propHashName = (String)enumer.nextElement();
            //System.out.println(propHashName);
            bigMap.put(propHashName, PropertyListManager.getPropertyHashAsJavaProperties("PCRCPPropLkup", propHashName));
            props.putAll(PropertyListManager.getPropertyHashAsJavaProperties("PCRCPPropLkup", propHashName));
        }
        
        System.out.println("The Value is :: " + props.get("2"));
       
    }
    
}

