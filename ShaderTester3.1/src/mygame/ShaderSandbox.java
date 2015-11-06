/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector2f;
import com.jme3.math.Vector3f;
import com.jme3.renderer.Camera;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.Geometry;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Quad;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;

/**
 *
 * @author lando
 */
public class ShaderSandbox extends SimpleApplication {
    
    Geometry backgroundGeom;
    
    public static void main(String[] args){
        ShaderSandbox app = new ShaderSandbox();
        AppSettings settings = new AppSettings(true);
        settings.setRenderer(AppSettings.LWJGL_OPENGL2);
        app.setSettings(settings);
        app.start();

    }
    @Override
    public void simpleInitApp() {
        
        this.flyCam.setMoveSpeed(100);
        this.flyCam.setRotationSpeed(4);
        
        float w = this.getContext().getSettings().getWidth();
        float h = this.getContext().getSettings().getHeight();
        float ratio = w / h;
        
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
        
        this.cam.setLocation(Vector3f.ZERO.add(new Vector3f(0.0f, 0.0f, 100f)));//Move the Camera back
        float camZ = cam.getLocation().getZ() - 15; //No Idea why I need to subtract 15
        float width = camZ * ratio;
        float height = camZ;
        
        Camera BackgroundCamera = cam.clone();
        BackgroundCamera.setViewPort(0f, 1f, 0f, 1f);
        BackgroundCamera.setLocation(cam.getLocation());
        BackgroundCamera.setRotation(cam.getRotation());
        
//        ViewPort view2 = renderManager.createPostView("Background", BackgroundCamera);
//        
//        //Make the Background
//        Material backgroundMat = new Material(assetManager, "Materials/RayMarchMat.j3md");
//        backgroundMat.setVector2("Mouse", inputManager.getCursorPosition());
//        Quad fsq = new Quad(width, height);
//        backgroundGeom = new Geometry("Background", fsq);
//        backgroundGeom.setQueueBucket(RenderQueue.Bucket.Sky);
//        backgroundGeom.setCullHint(Spatial.CullHint.Never);
//        backgroundGeom.setMaterial(backgroundMat);
//        backgroundGeom.setLocalTranslation(-(width / 2), -(height / 2), 0); //Need to Divide by two because the quad origin is bottom left
//        
//        view2.setClearFlags(false, false, false);
//        view2.attachScene(backgroundGeom);
//        
//        
//        backgroundGeom.updateGeometricState();
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
