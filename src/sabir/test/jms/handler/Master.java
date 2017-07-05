package sabir.test.jms.handler;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Master implements Serializable
 {
   List<File> f=new ArrayList<File>();

public List<File> getF() {
	return f;
}

public void setF(List<File> f) {
	this.f = f;
}


  //getter and setter
 }