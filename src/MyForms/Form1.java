package MyForms;
import MyForms.addproduct;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import raven.glasspanepopup.GlassPanePopup;
import net.miginfocom.swing.MigLayout;
import MyModel.Product;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;



public class Form1 extends javax.swing.JPanel {
     private addproduct Add;
    private ArrayList<Product> productList;
  
    public Form1() {
        initComponents();
        productList = new ArrayList<>();
        Add = new addproduct(this);
        
        DisplayIcon = new JPanel();
      
        DisplayIcon.setLayout(new BoxLayout(DisplayIcon, BoxLayout.Y_AXIS));

      
        JScrollPane scrollPane = new JScrollPane(DisplayIcon);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); 
        scrollPane.setPreferredSize(new java.awt.Dimension(820,30000)); 

   
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));  
        this.add(scrollPane);  
    }

 
    public void addProductToList(String name, String price, String quantity, ImageIcon productImage) {
        Product newProduct = new Product(name, price, quantity, productImage);
        productList.add(newProduct);
        updateProductDisplay();  
    }


    public void updateProductDisplay() {
        DisplayIcon.removeAll();  

        int productsPerRow = 5;  
        JPanel currentRowPanel = new JPanel();
        currentRowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  

       
        for (int i = 0; i < productList.size(); i++) {
            Product product = productList.get(i);
            JPanel productPanel = new JPanel();
            JLabel productNameLabel = new JLabel("Name: " + product.getName());
            JLabel productPriceLabel = new JLabel("Price: " + product.getPrice());
            JLabel productQuantityLabel = new JLabel("Quantity: " + product.getQuantity());
            JLabel productImageLabel = new JLabel();
            productImageLabel.setIcon(product.getImage());

            
            productPanel.add(productNameLabel);
            productPanel.add(productPriceLabel);
            productPanel.add(productQuantityLabel);
            productPanel.add(productImageLabel);

            
            currentRowPanel.add(productPanel);

            
            if ((i + 1) % productsPerRow == 0 || i == productList.size() - 1) {
                DisplayIcon.add(currentRowPanel);  
                currentRowPanel = new JPanel();  
                currentRowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));  
            }
        }

        DisplayIcon.revalidate();
        DisplayIcon.repaint();
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DisplayIcon = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        DisplayIcon.setRequestFocusEnabled(false);
        DisplayIcon.setVerifyInputWhenFocusTarget(false);

        jButton1.setText("Add Product");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Home");

        javax.swing.GroupLayout DisplayIconLayout = new javax.swing.GroupLayout(DisplayIcon);
        DisplayIcon.setLayout(DisplayIconLayout);
        DisplayIconLayout.setHorizontalGroup(
            DisplayIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DisplayIconLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        DisplayIconLayout.setVerticalGroup(
            DisplayIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DisplayIconLayout.createSequentialGroup()
                .addGroup(DisplayIconLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DisplayIconLayout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jButton1))
                    .addGroup(DisplayIconLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(389, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DisplayIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DisplayIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        GlassPanePopup.showPopup(Add);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DisplayIcon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}