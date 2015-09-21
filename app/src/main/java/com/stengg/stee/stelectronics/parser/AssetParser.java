package com.stengg.stee.stelectronics.parser;

import com.stengg.stee.stelectronics.models.Asset;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class AssetParser {

    // We don't use namespaces
    private static final String ns = null;

    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {

            // Create a new DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Use the factory to create a document builder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Create a new document from input stream
            Document doc = builder.parse(in);

            // Get the first element
            Element element = doc.getDocumentElement();

            // Get All Child nodes
            NodeList nodes = element.getChildNodes();

            // Print the text
            for (int i = 0; i < nodes.getLength(); i++) {
                NodeList children = nodes.item(i).getChildNodes();

            }


//            XmlPullParser parser = Xml.newPullParser();
//            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
//            parser.setInput(in, null);
//            parser.nextTag();
//            return readPublishedAsset(parser);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } finally {
            in.close();
        }

        return null;
    }

    private List readPublishedAsset(XmlPullParser parser) throws XmlPullParserException, IOException {
        List entries = new ArrayList();


        parser.require(XmlPullParser.START_TAG, ns, "PublishMBLASSET");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("MBLASSETSet")) {
                entries = readMBLAsset(parser);
            } else {
                skip(parser);
            }
        }
        return entries;
    }

    private List readMBLAsset(XmlPullParser parser) throws XmlPullParserException, IOException {
        List entries = new ArrayList();
        parser.require(XmlPullParser.START_TAG, ns, "MBLASSETSet");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("ASSET")) {
                entries.add(readAsset(parser));
            } else {
                skip(parser);
            }
        }

        return entries;
    }

    private Asset readAsset(XmlPullParser parser) throws XmlPullParserException, IOException {
        parser.require(XmlPullParser.START_TAG, ns, "ASSET");
        String assetCode = null;
        String assetNum = null;
        String description = null;
        String location = null;
        String usage = null;
        String parent = null;
        String orgid = null;
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            if (name.equals("ASSETCODE")) {
                assetCode = readAssetCode(parser);
            } else if (name.equals("ASSETNUM")) {
                assetNum = readAssetNum(parser);
            } else if (name.equals("DESCRIPTION")) {
                description = readDescription(parser);
            } else if (name.equals("LOCATION")) {
                location = readLocation(parser);
            } else if (name.equals("USAGE")) {
                usage = readUsage(parser);
            } else if (name.equals("PARENT")) {
                parent = readParent(parser);
            } else if (name.equals("ORGID")) {
                orgid = readOrg(parser);
            }else {
                skip(parser);
            }
        }

        return new Asset(assetNum, assetCode, description, location, orgid, usage, "", parent);
    }

    // Processes title tags in the feed.
    private String readOrg(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "ORGID");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "ORGID");
        return title;
    }

    // Processes title tags in the feed.
    private String readParent(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "PARENT");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "PARENT");
        return title;
    }

    // Processes title tags in the feed.
    private String readUsage(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "USAGE");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "USAGE");
        return title;
    }

    // Processes title tags in the feed.
    private String readLocation(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "LOCATION");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "LOCATION");
        return title;
    }

    // Processes title tags in the feed.
    private String readDescription(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "DESCRIPTION");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "DESCRIPTION");
        return title;
    }

    // Processes title tags in the feed.
    private String readAssetNum(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "ASSETNUM");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "ASSETNUM");
        return title;
    }


    // Processes title tags in the feed.
    private String readAssetCode(XmlPullParser parser) throws IOException, XmlPullParserException {
        parser.require(XmlPullParser.START_TAG, ns, "ASSETCODE");
        String title = readText(parser);
        parser.require(XmlPullParser.END_TAG, ns, "ASSETCODE");
        return title;
    }

    // For the tags title and summary, extracts their text values.
    private String readText(XmlPullParser parser) throws IOException, XmlPullParserException {
        String result = "";
        if (parser.next() == XmlPullParser.TEXT) {
            result = parser.getText();
            parser.nextTag();
        }
        return result;
    }


    private void skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
