
package com.lumtec.computo;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 *
 * @author Luis
 */
public class ClipBoar {
    
    public static void copy(String text)
    {
        Clipboard clipboard = getSystemClipboard();

        clipboard.setContents(new StringSelection(text), null);
    }
    
    private static Clipboard getSystemClipboard()
    {
        Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
        Clipboard systemClipboard = defaultToolkit.getSystemClipboard();

        return systemClipboard;
    }
}
