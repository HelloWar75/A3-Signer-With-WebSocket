/*
 * Copyright (C) 2021 Luis Justin <contato@luisjustin.com.br>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.luisjustin.localsigner.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luis Justin <contato@luisjustin.com.br>
 */
public class ConfigLoader {
    
    private static ConfigLoader instance = new ConfigLoader();
    private static final String _configFilePath = "./config.properties";
    private static String _appVersion = "0.0.1a";
    private FileInputStream _fileStream;
    private Properties _props;
    
    private ConfigLoader() {
        
        System.out.println("Initializing ConfigLoader");
        
        try {
            this._fileStream = new FileInputStream(ConfigLoader._configFilePath);
            this._props = new Properties();
            this._props.load(_fileStream);
            this._fileStream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConfigLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static synchronized ConfigLoader getInstance() {
    
        return instance;
        
    }
    
    public String getErrorLogPath() {
        return (String)this._props.getProperty("errorLogPath");
    }
    
    public String getOutLogPath() {
        return (String)this._props.getProperty("outLogPath");
    }
}
