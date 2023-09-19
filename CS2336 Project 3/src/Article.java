public class Article {
   int id;
   String title;
   String author;
   Article next;
 
  Article(int i, String t, String a, Article r) {
      this.id = i;
      this.title = t;
      this.author = a;
      this.next = r;
   }
}