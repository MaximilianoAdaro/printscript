package interpreter.visitor;

import parser.node.impl.PrintNode;

public class ValidationVisitor extends AbstractNodeVisitor {

  @Override
  public void visit(PrintNode printNode) {
    printNode.getCalculable().calculate(this);
  }
}
