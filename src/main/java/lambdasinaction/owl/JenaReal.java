package lambdasinaction.owl;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.jena.graph.Node;
import org.apache.jena.ontology.*;
import org.apache.jena.rdf.model.*;
import org.apache.jena.util.FileManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

import static org.apache.jena.ontology.OntModelSpec.RDFS_MEM;

public class JenaReal {
    private static final Logger logger = LoggerFactory.getLogger(JenaReal.class);

    public static void main(String[] args) throws IOException {
        System.out.println(Optional.empty().isPresent());;
//        OntModelSpec ontModelSpec=OntModelSpec.OWL_MEM;
        OntModel ontModel = ModelFactory.createOntologyModel(RDFS_MEM,null);
//        OntModel ontModel = ModelFactory.createOntologyModel(RDFS_MEM);
        java.io.InputStream in = FileManager.get().open("src/main/java/lambdasinaction/ahandful/zhihurdfs.ttl");  //MyFile

        ontModel.read(new InputStreamReader(new BOMInputStream(in, false), StandardCharsets.UTF_8), "", "TTL");
//        listClasses(ontModel);
//        listStatements(ontModel);
        modifyPredicate(ontModel);
    }

    public static void listStatements(OntModel ontModel) {
        List<ObjectProperty> objectProperties = ontModel.listObjectProperties().toList();
        ontModel.getDatatypeProperty("Person");
        objectProperties.forEach(
                objectProperty -> {
                    System.out.println(objectProperty.getDomain());
                    System.out.println(objectProperty.getRange());
                }
        );
        StmtIterator iter = ontModel.listStatements();
        // print out the predicate, subject and object of each statement
        while (iter.hasNext()) {
            Statement stmt = iter.nextStatement(); // get next statement
            //Resource subject = stmt.getSubject(); // get the subject
            //Property predicate = stmt.getPredicate(); // get the predicate
            //RDFNode object = stmt.getObject(); // get the object

            //主语
            Resource subject = stmt.getSubject();
            subject.getClass();
            List<Statement> statements = subject.listProperties().toList();
            statements.forEach(
                    statement -> {
                        System.out.println(statement.getPredicate());
                    }
            );
            try {
                System.out.print("主语 " + subject.toString());
                System.out.println("主语uri " + subject.getURI());
                System.out.println(subject.getLocalName());
                System.out.println(subject.getNameSpace());

                AnonId id = stmt.getSubject().getId();
                System.out.println("主语id LabelString " + id.getLabelString());
                System.out.println("主语id BlankNodeId" + id.getBlankNodeId());
                System.out.println("主语id-class " + id.getClass());

                Node node = stmt.getSubject().asNode();
                System.out.println("主语node LocalName" + node.getLocalName());
                System.out.println("主语node Name" + node.getName());
                System.out.println("主语node id" + node.getURI());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            //谓语
            Property predicate = stmt.getPredicate(); // get the predicate
            System.out.print(" 谓语 " + predicate.toString());
            System.out.println(" 谓语名称 " + predicate.getLocalName());

            //宾语
            RDFNode object = stmt.getObject(); // get the object
            if (object instanceof Resource) {
                System.out.print(" 宾语 " + object);
            } else {// object is a literal
                System.out.print("宾语 \"" + object.toString() + "\"");
            }
            System.out.println(" .");
        }
        List<OntClass> ontClasses = ontModel.listClasses().toList();
        ontClasses.stream().forEach(System.out::println);
    }

    public static void listClasses(OntModel ontModel){
        List<OntClass> ontClasses = ontModel.listClasses().toList();
        ontClasses.stream().forEach(
                ontClass -> {
                    System.out.println(ontClass.getLocalName());
                    //无法像具体的数值属性
                    DatatypeProperty datatypeProperty1 = ontModel.getDatatypeProperty("Person");
                    ontModel.listDatatypeProperties().toList().stream().forEach(
                            datatypeProperty -> {
                                System.out.println(datatypeProperty.getDomain().getURI());
                                System.out.println(datatypeProperty.getRange().getLocalName());
                            }
                    );
                    ontClass.listInstances();
                }
        );
    }

    public static void modifyPredicate(OntModel ontModel){
        List<OntClass> ontClasses = ontModel.listClasses().toList();
        System.out.println(ontClasses.get(0).getLocalName());
        System.out.println(ontClasses.get(1).getLocalName());
        List<OntProperty> ontProperties = ontClasses.get(1).listDeclaredProperties().toList();
        List<OntProperty> ontProperties1 = ontClasses.get(2).listDeclaredProperties().toList();
        ontProperties1.stream().forEach(
                ontProperty -> {
                    System.out.print(ontProperty.getLocalName());
                    System.out.print(" domain-");
                    System.out.print(ontProperty.getDomain().getLocalName());
                    System.out.print(" panduan-");
                    System.out.print(ontProperty.getDomain().isClass());
                    System.out.print(" range-");
                    System.out.print(ontProperty.getRange().getLocalName());
                    System.out.print(ontProperty.getRange().getLocalName().equals(ontClasses.get(0).getLocalName()));
                    System.out.println();
//                    System.out.print(" -");
                }
        );
        System.out.println("Have a nice day!");
//        List<Statement> statements = ontModel.listStatements().toList();
//        statements.stream().forEach(
//                item->{
//                    item.getPredicate();
//                }
//        );
//        List<OntClass> ontClasses2 = ontModel.listClasses().toList();
//        List<OntClass> ontClasses = ontModel.listHierarchyRootClasses().toList();
//        ontClasses.stream().forEach(
//                item->{
//                    List<OntClass> ontClasses1 = item.listSubClasses(true).toList();
//                }
//        );
    }
}
