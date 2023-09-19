import java.util.Scanner;
import java.io.*;
class FileData{
   int id;
   String title;
   String author;
   String keywords[];
   FileData(int id, String title, String author, int keywordCount){ //Cons
      this.id=id;
      this.title=title;
      this.author=author;
      keywords=new String[keywordCount];
      for(int i=0;i<keywords.length;i++){
         keywords[i]=null;
      }
    }
 }