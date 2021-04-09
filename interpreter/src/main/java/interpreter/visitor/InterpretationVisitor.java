package interpreter.visitor;

import interpreter.interpetation.Writer;
import parser.node.impl.PrintNode;

public class InterpretationVisitor extends AbstractNodeVisitor {

  private final Writer writer;

  public InterpretationVisitor(Writer writer) {
    this.writer = writer;
  }

  @Override
  public void visit(PrintNode printNode) {
    writer.write(printNode.getCalculable().calculate(this).toString());
  }
}
