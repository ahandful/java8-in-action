package lambdasinaction.owl;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.jena.ontology.AnnotationProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.impl.LiteralImpl;
import org.apache.jena.util.FileManager;

public class Jena {
    public static void main(String[] args) throws IOException {
        OntModel mode = null;
        mode = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        java.io.InputStream in = FileManager.get().open("src/main/java/lambdasinaction/ahandful/xuyu.ttl");  //MyFile
        byte b[] = new byte[1024]; //创建合适文件大小的数组

        PushbackReader pushbackReader = new PushbackReader(new InputStreamReader(new BOMInputStream(in, false), StandardCharsets.UTF_8), 8);
        char cbuf[]=new char[8];
        pushbackReader.read(cbuf);
        System.out.println(new String(cbuf));
        pushbackReader.unread(cbuf);
        pushbackReader.read(cbuf);
        System.out.println(new String(cbuf));
//        in.read(b); //读取文件里的内容到b[]数组
//        System.out.println(b[1]);
//        in.close();
//        System.out.println(new String(b));
    }
}
