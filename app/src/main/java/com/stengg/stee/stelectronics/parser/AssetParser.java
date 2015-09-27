package com.stengg.stee.stelectronics.parser;

import android.os.Environment;

import com.stengg.stee.stelectronics.models.Asset;
import com.stengg.stee.stelectronics.models.PublishMBLASSET;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Balingit on 18/9/2015.
 */
public class AssetParser {

    // We don't usRe namespaces
    private static final String ns = null;

    public List parse(String path) throws Exception {

        File dir = Environment.getExternalStorageDirectory();
        File yourFile = new File(dir, path);

        Serializer serializer = new Persister();

        PublishMBLASSET example = serializer.read(PublishMBLASSET.class, yourFile, false);
        return example.getMBLASSETSet().getASSET();
    }
}
