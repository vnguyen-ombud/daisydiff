package org.outerj.daisy.diff.html.dom;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Represents an video in HTML. Even though videos do not contain any text they
 * are single visible objects on the page. They are logically a {@link TextNode}.
 */
public class VideoNode extends TextNode {

    private AttributesImpl attributes;

    public VideoNode(TagNode parent, Attributes attrs) {
        super(parent, "<iframe>" + attrs.getValue("src").toLowerCase() + "</iframe>");
        attributes = new AttributesImpl(attrs);
    }

    @Override
    public boolean isSameText(Object other) {
        if (other == null)
            return false;

        VideoNode otherVideoNode;
        try {
            otherVideoNode = (VideoNode) other;
        } catch (ClassCastException e) {
            return false;
        }
        return getText().equalsIgnoreCase(otherVideoNode.getText());
    }

    public AttributesImpl getAttributes() {
        return attributes;
    }

}
