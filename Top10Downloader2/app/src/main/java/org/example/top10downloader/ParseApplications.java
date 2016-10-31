package org.example.top10downloader;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class ParseApplications {
    /*main data that is sent to this class*/
    private String data;

    private ArrayList<Application> applications;

    public ParseApplications(String xmlData) {
        data = xmlData;
        /*initialize the array*/

        applications = new ArrayList<Application>();
    }

    /*getter to retrieve the data main activity will call it*/
    public ArrayList<Application> getApplications() {
        return applications;
    }

    public boolean testProcess() {
        boolean operationStatus = true;
        Application currentRecord = null;
        boolean inEntry = false;
        String textValue = "";
        List<String> imageList = new ArrayList<>();

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();

            xpp.setInput(new StringReader(this.data));
            int eventType = xpp.getEventType();
            /*we need to iterate*/
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();

                if (eventType == XmlPullParser.START_TAG) {
                    if (tagName.equalsIgnoreCase("entry")) {
                        inEntry = true;


                        currentRecord = new Application();
                    }

                }  else if (eventType == XmlPullParser.TEXT) {
                    textValue = xpp.getText();

                } else if (eventType == XmlPullParser.END_TAG) {

                    if (inEntry) {
                        if (tagName.equalsIgnoreCase("entry")) {

                            currentRecord.setImages(imageList);
                            applications.add(currentRecord);
                            inEntry = false;
                        }
                        if (tagName.equalsIgnoreCase("name")) {
                            currentRecord.setName(textValue);
                        }
                        if (tagName.equalsIgnoreCase("artist")) {
                            currentRecord.setArtist(textValue);
                        }
                        if (tagName.equalsIgnoreCase("releaseDate")) {
                            currentRecord.setReleaseDate(textValue);
                        }
                        if (tagName.equalsIgnoreCase("image")) {
                            imageList.add(textValue);

                        }
                    }
                }
                eventType = xpp.next();
            }


        } catch (Exception e) {
            e.printStackTrace();
            operationStatus = false;
        }
        for (Application app : applications) {
            Log.d("LOG", "**************");
            Log.d("LOG", app.getName());
            Log.d("LOG", app.getArtist());
            Log.d("LOG", app.getReleaseDate());
            for (String image : app.getImages()) {
                Log.d("Log", image);
            }
        }
        return operationStatus;
    }


    public boolean process() {

        /*if error we will change that status*/
        boolean operationStatus = true;

        Application currentRecord = null;
        /*are we in the beginning meaning in the entry*/
        boolean inEntry = false;
        String textValue = "";

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();


            xpp.setInput(new StringReader(this.data));
            int eventType = xpp.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                if (eventType == XmlPullParser.START_TAG) {
                    if (tagName.equalsIgnoreCase("entry")) {
                        inEntry = true;
                        currentRecord = new Application();
                    }
                } else if (eventType == XmlPullParser.TEXT) {
                    textValue = xpp.getText();
                } else if (eventType == XmlPullParser.END_TAG) {
                    if (inEntry) {
                        if (tagName.equalsIgnoreCase("entry")) {
                            applications.add(currentRecord);
                            inEntry = false;
                        }
                        if (tagName.equalsIgnoreCase("name")) {
                            currentRecord.setName(textValue);
                        } else if (tagName.equalsIgnoreCase("artist")) {
                            currentRecord.setArtist(textValue);
                        } else if (tagName.equalsIgnoreCase("releaseDate")) {
                            currentRecord.setReleaseDate(textValue);
                        }

                    }

                }

                eventType = xpp.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
            operationStatus = false;
        }

        for (Application app : applications) {
            Log.d("LOG", "**************");
            Log.d("LOG", app.getName());
            Log.d("LOG", app.getArtist());
            Log.d("LOG", app.getReleaseDate());
        }

        return operationStatus;
    }


}
