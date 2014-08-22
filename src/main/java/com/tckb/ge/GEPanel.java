/*
 * GoogleEarthPanel.java
 *
 * Created on December 5, 2007, 9:19 AM
 */
package com.tckb.ge;

import com.tckb.ge.stubs.IApplicationGE;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import org.jawin.COMException;
import org.jawin.FuncPtr;
import org.jawin.ReturnFlags;
import org.jawin.donated.win32.RECT;
import org.jawin.donated.win32.User32;
import org.jawin.io.LittleEndianOutputStream;
import org.jawin.io.NakedByteStream;
import sun.awt.windows.WToolkit;

public class GEPanel extends JPanel implements Serializable {

    private IApplicationGE ge;

    public GEPanel() {
        initComponents();
    }

    public void loadKMLString(String kmlData) throws COMException {
        this.ge.LoadKmlData(kmlData);

    }

    public void loadKMLFile(String kmlFile) throws COMException {
        this.ge.OpenKmlFile(kmlFile, 0);

    }

    public void loadKmlFile(File file) throws COMException {
        this.loadKMLFile(file.getAbsolutePath());
    }

    public void initGE() throws COMException, InterruptedException, IOException {
        //Start Google Earth
        ge = new IApplicationGE("GoogleEarth.ApplicationGE");
        System.out.print("Initializing Google Earth ");
        while (ge.IsInitialized() <= 0) {
            Thread.sleep(350);
            System.out.print(".");
        }
        System.out.println("\nGoogle Earth Initialized.\n");
        System.out.println("Auto pilot speed:" + ge.getAutoPilotSpeed());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void setGEWinVisibility(boolean flag) throws COMException, IOException {
        User32.ShowWindow(getGEMainHandle(), flag ? 3 : 0);
    }

    public int getGEMainHandle() throws COMException {
        return (Integer) this.ge.GetMainHwnd();
    }

    public int getGERenderHandle() throws COMException {
        return (Integer) ge.GetRenderHwnd();
    }

    private Field getDeclaredField(Class cls, String fieldName) throws NoSuchFieldException {
        Class c = cls;
        while (c != null && c != Object.class) {
            try {
                return c.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
            }
            c = c.getSuperclass();
        }
        throw new NoSuchFieldException(fieldName);
    }

    private int getParentHandle() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        int hwnd = 0;
        Object nativePeer = WToolkit.targetToPeer(SwingUtilities.getWindowAncestor(this));
        Class nativeClass = nativePeer.getClass();
        Field f = getDeclaredField(nativeClass, "hwnd");
        f.setAccessible(true);
        hwnd = ((Long) f.get(nativePeer)).intValue();
        System.out.println("parent handle " + hwnd);
        return hwnd;
    }

    public void embedGE() throws COMException, InterruptedException, IOException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        if (this.isVisible()) {
            System.out.println("render " + getGERenderHandle());
            this.setGEWinVisibility(false);
            this.swapHandles(getGERenderHandle(), getParentHandle());
            // this.resizeGERenderHwnd();
        }
    }

    private void swapHandles(int srcHandle, int dstHandle) throws COMException {
        FuncPtr setParent = new FuncPtr("USER32.DLL", "SetParent");
        setParent.invoke_I(srcHandle, dstHandle, ReturnFlags.CHECK_FALSE);
    }

    public Dimension getGERenderDimension() throws COMException, IOException {
        RECT dim = new RECT();
        User32.GetClientRect(getGERenderHandle(), dim);
        return new Dimension(dim.right + 10, dim.bottom + 10);
    }

    public void quitGE() {
        try {
            FuncPtr endTask = new FuncPtr("USER32.DLL", "EndTask");
            //create a NakedByteStream for the serialization of Java variables
            NakedByteStream nbs = new NakedByteStream();
            // wrap it in a LittleEndianOutputStream
            LittleEndianOutputStream leos = new LittleEndianOutputStream(nbs);
            // and then write the Java arguments
            leos.writeInt(getGERenderHandle());      //Handle to the window to be closed.
            leos.writeInt(0);                       // Ignored. Must be FALSE.
            leos.writeInt(1);
            /* TRUE for this parameter will force the destruction of the window if an  
             { initial } attempt fails to gently close the window using 
             WM_CLOSE.With a FALSE for this parameter , only  { the 
             } close with WM_CLOSE is attempted. */
            endTask.invoke("III:I:", 12, nbs, null, ReturnFlags.CHECK_FALSE);
        } catch (COMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public IApplicationGE getInternObject() {
        return ge;
    }

}


