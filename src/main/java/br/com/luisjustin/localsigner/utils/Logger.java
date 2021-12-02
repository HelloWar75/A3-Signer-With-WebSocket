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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;
import org.bouncycastle.util.io.TeeOutputStream;

/**
 *
 * @author Luis Justin <contato@luisjustin.com.br>
 */
public class Logger {
    
    public void initLogger() throws IOException {
        
        System.out.println("Initializing Logger");
        
        Date date = new Date();
        Long actTime = date.getTime();
        
        ConfigLoader cl = ConfigLoader.getInstance();
        
        System.out.println("Set log system to paths: ");
        System.out.println("Error Log File: " + cl.getErrorLogPath() + "-" + actTime.toString() + ".log");
        System.out.println("Out Log File: " + cl.getOutLogPath() + "-" + actTime.toString() + ".log");
        
        File errorLogFile = new File(cl.getErrorLogPath() + "-" + actTime.toString() + ".log");
        File outLogFile = new File(cl.getOutLogPath() + "-" + actTime.toString() + ".log");
        
        errorLogFile.delete();
        outLogFile.delete();
        
        errorLogFile.createNewFile();
        outLogFile.createNewFile();
        
        System.setErr(new PrintStream(new TeeOutputStream(System.err, new FileOutputStream(errorLogFile)), true));
        System.setOut(new PrintStream(new TeeOutputStream(System.out, new FileOutputStream(outLogFile)), true));
        
    }
    
}
