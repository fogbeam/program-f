package org.alicebot.ab;


import org.w3c.dom.Node;

import java.util.Set;

public interface AIMLProcessorExtension {

   public Set<String> extensionTagSet();
   public String recursEval(Node node, ParseState ps);
}
