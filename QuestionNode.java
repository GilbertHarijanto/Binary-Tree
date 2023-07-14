/**@Gilbert CS145 QuestionNode
 *@version 1.0 (06/08/2023)
 *@see QuestionNode class*/
 
public class QuestionNode {
   private String data;
   private QuestionNode yes;
   private QuestionNode no;
   
   /*Construct a new QuestionNode with data, yes and no nodes.
   @param data the data for the node.
   @param yes the yes node.
   @param no the no node.
   */
   public QuestionNode(String data, QuestionNode yes, QuestionNode no) {
      this.data = data;
      this.yes = yes;
      this.no = no;
   }
   
   /*Construct a new QuestionNode with only data.
   @param data the data for the node.
   */
   public QuestionNode(String data) {
      this(data, null, null);
   }

   /*Get the data of this node.
   @return the data of this node.
   */
   public String getData() {
      return this.data;
   }

   /*Get the yes of this node.
   @return the yes of this node.
   */
   public QuestionNode getYesNode() {
      return this.yes;
   }

   /*Get the no of this node.
   @return the no of this node.
   */
   public QuestionNode getNoNode() {
      return this.no;
   }
   
   /*Set the data of this node.
   @param data the new data for this node.
   */
   public void setData(String data) {
      this.data = data;
   }
   
   /*Set the yes node of this node.
   @param yes the new yes node for this node.
   */
   public void setYesNode(QuestionNode yes) {
      this.yes = yes;
   }

   /*Set the no node of this node.
   @param no the new no node for this node.
   */
   public void setNoNode(QuestionNode no) {
      this.no = no;
   }
}