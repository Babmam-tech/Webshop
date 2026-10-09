package se.iths.eitvydas.webshop.model;

public class Product {

        private String articleNumber;
        private String title;
        private double price;
        private String description;

        public Product (String articleNumber, String title, double price, String description) {
            this.articleNumber = articleNumber;
            this.title = title;
            this.price = price;
            this.description = description;
        }

        public String getArticleNumber(){
            return this.articleNumber;
        }

        public String getTitle(){
            return this.title;
        }

        public double getPrice(){
            return this.price;
        }

        public String getDescription(){
            return this.description;
        }

        public void setArticleNumber(String articleNumber){
            this.articleNumber = articleNumber;
        }

        public void setTitle(String title){
            this.title = title;
        }

        public void setPrice(double price){
            this.price = price;
        }

        public void setDescription(String description){
            this.description = description;
        }

}
