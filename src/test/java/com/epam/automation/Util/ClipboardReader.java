package com.epam.automation.Util;

import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;


public class ClipboardReader {
    public static void cleanClipboard(){
        StringSelection stringSelection = new StringSelection("TEST LINE");
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection,null);
    }

    public static String getLineFromClipboard() {
        String lineFromClipboard="";
        Clipboard clipboard= Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents=clipboard.getContents(null);
        boolean hasTransferable = (contents != null) && contents.isDataFlavorSupported(DataFlavor.stringFlavor);
        if(hasTransferable){
            try {
                lineFromClipboard=(String)contents.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return (lineFromClipboard);
    }
}
