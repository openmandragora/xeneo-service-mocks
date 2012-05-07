/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.xeneo.mock;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.xeneo.core.activity.Activity;
import org.xeneo.core.activity.ActivityStream;
import org.xeneo.core.activity.Filter;
import org.xeneo.core.activity.Object;

/**
 *
 * @author Stefan
 */
public class ActivityStreamMock implements ActivityStream {

    private String testURI = "http://test.xeneo.org/";
    
    public List<Activity> createRandomActivities(String uniquePath, int n) {
        List<Activity> acts = new ArrayList<Activity>();

        for (int i = 0; i < n; i++) {
            Activity a = new Activity();
            a.setActivityURI(testURI + uniquePath + "/activity/" + i);
            a.setActionURI(testURI + "action/" + i);
            a.setActorURI("http://stefanhuber.at/user/stefan");
            a.setCreationDate(Calendar.getInstance().getTime());
            a.setSummary("Summary of activity for: " + i);
            a.setDescription("Content of activity for: " + i);

            Object obj = new org.xeneo.core.activity.Object();
            obj.setObjectURI(testURI + "object/" + i);
            obj.setObjectName("object name: " + i);
            obj.setObjectTypeURI(testURI + "objectType/" + i);

            Object tar = new org.xeneo.core.activity.Object();
            tar.setObjectURI(testURI + "target/" + i);
            tar.setObjectName("target name: " + i);
            tar.setObjectTypeURI(testURI + "objectType/" + i);

            a.setObject(obj);
            a.setTarget(tar);

            acts.add(a);
        }

        return acts;
    }
    
    public List<Activity> getActivities(String caseURI, String taskURI, int limit) {
        return this.createRandomActivities("test/", limit);
    }

    public List<Activity> getActivities(String caseURI, int limit) {
        return this.createRandomActivities("test/", limit);
    }

    public List<Activity> getActivities(Filter filter) {
        return this.createRandomActivities("test/", 20);
    }
    
}
