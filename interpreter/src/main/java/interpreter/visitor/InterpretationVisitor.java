package interpreter.visitor;

import parser.node.impl.PrintNode;

public class InterpretationVisitor extends AbstractNodeVisitor {

  @Override
  public void visit(PrintNode printNode) {
    System.out.println(printNode.getCalculable().calculate(this));
  }
}
