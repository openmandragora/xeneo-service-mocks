/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xeneo.mock;

import java.util.ArrayList;
import java.util.List;
import org.xeneo.core.plugin.PluginDescriptor;
import org.xeneo.core.plugin.PluginManager;
import org.xeneo.core.plugin.PluginProperty;

/**
 *
 * @author Stefan Huber
 */
public class PluginManagerMock implements PluginManager {

    List<PluginDescriptor> pds = new ArrayList<PluginDescriptor>();
    
    public void addPlugin(PluginDescriptor descriptor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void deactivatePlugin(String pluginURI) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<PluginDescriptor> listAvailablePlugins(String[] types) {
        return pds;
    }

    public PluginDescriptor getPluginDescriptor(String pluginURI) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public PluginManagerMock() {
        PluginDescriptor pd = new PluginDescriptor();
        pd.setTitle("Dropbox Plugin");        
        PluginProperty<String> p1 = new PluginProperty<String>();
        p1.setName("RSS Feed");
        p1.setValue("some url...");
        pd.addPluginInstanceProperty(p1);
        pds.add(pd);
        
        pd = new PluginDescriptor();
        pd.setTitle("Alfresco Plugin");
        pds.add(pd);
        
        pd = new PluginDescriptor();
        pd.setTitle("SugarCRM Plugin");
        pds.add(pd);
        
        
        
    }
    
}
