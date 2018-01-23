package com.dp3.printable;

import com.lowagie.text.Document;

public interface Printable {
    Document getDocument(Document doc);
    String getPdfName();
}
