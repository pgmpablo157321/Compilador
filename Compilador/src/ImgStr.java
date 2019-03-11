import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Queue;
import java.util.Stack;

import javax.imageio.ImageIO;

public class ImgStr {
		
	private static Stack<Integer> binaryRepresentation(int a){
		Stack<Integer> bin=new Stack<Integer>();
		while(a>1){
			bin.push(a%2);
			a/=2;
		}
		return bin;
	}
	
	
	
	
	public ImgStr(Queue <String> a){
		
		int cont=0;
		String operators="*/+-";
		String aux="";
		Color mat[][]=new Color[6][3];
		
		mat[0][0]=new Color(255,192,192);
		mat[0][1]=new Color(255,0,0);
		mat[0][2]=new Color(192,0,0);
		mat[1][0]=new Color(255,255,192);
		mat[1][1]=new Color(255,255,0);
		mat[1][2]=new Color(192,192,0);
		mat[2][0]=new Color(192,255,192);
		mat[2][1]=new Color(0,255,0);
		mat[2][2]=new Color(0,192,0);
		mat[3][0]=new Color(192,255,255);
		mat[3][1]=new Color(0,255,255);
		mat[3][2]=new Color(0,192,192);
		mat[4][0]=new Color(192,192,255);
		mat[4][1]=new Color(0,0,255);
		mat[4][2]=new Color(0,0,192);
		mat[5][0]=new Color(255,192,255);
		mat[5][1]=new Color(255,0,255);
		mat[5][2]=new Color(192,0,192);
		
		
		
		
		
		BufferedImage img= new BufferedImage(a.size()*30, 5, BufferedImage.TYPE_INT_RGB);
		
		for(int i=0;i<img.getHeight();i++){
			 for(int j=0;j<img.getWidth();j++){
				 img.setRGB(j, i, Color.WHITE.getRGB());
			 }
		 }
		
		
		
		while(!a.isEmpty()&&cont<img.getWidth()){
			aux=a.poll();
			if(operators.contains(aux)){
				switch(aux){
				case "+":
					img.setRGB(cont, 0, mat[0][0].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[1][0].getRGB());
				break;
				case "-":
					img.setRGB(cont, 0, mat[0][0].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[1][1].getRGB());
					break;
				case "*":
					img.setRGB(cont, 0, mat[0][0].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[1][2].getRGB());
					break;
				case "/":
					img.setRGB(cont, 0, mat[0][0].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[2][0].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[0][0].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[0][1].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[2][2].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[3][0].getRGB());
					cont++;
					break;
				
				}
				cont++;
				cont++;
			}else{
				int actual=Integer.parseInt(aux);
				
				if(actual>0){
					Stack<Integer>bin=binaryRepresentation(actual);
					img.setRGB(cont, 0, mat[0][1].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[0][2].getRGB());
					cont++;
					cont++;
					while(!bin.isEmpty()){
						if(bin.pop()==0){
							img.setRGB(cont, 0, mat[0][1].getRGB());
							img.setRGB(cont, 1, mat[0][1].getRGB());
							cont++;
							img.setRGB(cont, 0, mat[0][2].getRGB());
							cont++;
							img.setRGB(cont, 0, mat[1][1].getRGB());
							cont++;
							cont++;
							
						}else{
							
							img.setRGB(cont, 0, mat[0][1].getRGB());
							img.setRGB(cont, 1, mat[0][1].getRGB());
							cont++;
							img.setRGB(cont, 0, mat[0][2].getRGB());
							cont++;
							img.setRGB(cont, 0, mat[1][1].getRGB());
							cont++;
							cont++;
							img.setRGB(cont, 0, mat[0][1].getRGB());
							cont++;
							img.setRGB(cont, 0, mat[0][2].getRGB());
							cont++;
							img.setRGB(cont, 0, mat[1][2].getRGB());
							cont++;
							cont++;
						}
					}
					//for(int i=0;i<actual;i++){
					//img.setRGB(cont, i, mat[0][1].getRGB());
					//}
					//cont++;
					//img.setRGB(cont, 0, mat[0][2].getRGB());
					//cont++;
					//cont++;
				}else{
					img.setRGB(cont, 0, mat[0][1].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[0][2].getRGB());
					cont++;
					img.setRGB(cont, 0, mat[2][1].getRGB());
					cont++;
					cont++;
					
					if(actual<0){
						actual=-actual;
						
						Stack<Integer>bin=binaryRepresentation(actual);
						img.setRGB(cont, 0, mat[0][1].getRGB());
						cont++;
						img.setRGB(cont, 0, mat[0][2].getRGB());
						cont++;
						cont++;
						while(!bin.isEmpty()){
							if(bin.pop()==0){
								img.setRGB(cont, 0, mat[0][1].getRGB());
								img.setRGB(cont, 1, mat[0][1].getRGB());
								cont++;
								img.setRGB(cont, 0, mat[0][2].getRGB());
								cont++;
								img.setRGB(cont, 0, mat[1][1].getRGB());
								cont++;
								cont++;
								
							}else{
								
								img.setRGB(cont, 0, mat[0][1].getRGB());
								img.setRGB(cont, 1, mat[0][1].getRGB());
								cont++;
								img.setRGB(cont, 0, mat[0][2].getRGB());
								cont++;
								img.setRGB(cont, 0, mat[1][1].getRGB());
								cont++;
								cont++;
								img.setRGB(cont, 0, mat[0][1].getRGB());
								cont++;
								img.setRGB(cont, 0, mat[0][2].getRGB());
								cont++;
								img.setRGB(cont, 0, mat[1][2].getRGB());
								cont++;
								cont++;
							}
						
						//for(int i=1;i<(-actual);i++){
							//img.setRGB(cont, i, mat[2][1].getRGB());
						//}
						//cont++;
						//img.setRGB(cont, 0, mat[2][2].getRGB());
						//cont++;
						//img.setRGB(cont, 0, mat[3][0].getRGB());
						
					}
						
						img.setRGB(cont, 0, mat[0][1].getRGB());
						cont++;
						img.setRGB(cont, 0, mat[1][2].getRGB());
						cont++;
						cont++;
				}
				
			};
			
			
		}
		}
		
		img.setRGB(cont, 0, mat[0][1].getRGB());
		cont++;
		img.setRGB(cont, 0, mat[5][2].getRGB());
		cont++;
		cont++;
		cont++;
		cont++;
		
		img.setRGB(cont, 0, mat[2][1].getRGB());
		
		
		img.setRGB(cont-1, 3, mat[2][1].getRGB());
		img.setRGB(cont, 3, mat[2][1].getRGB());
		img.setRGB(cont+1, 3, mat[2][1].getRGB());
		
		img.setRGB(cont-1, 2, Color.BLACK.getRGB());
		img.setRGB(cont+1, 2, Color.BLACK.getRGB());
		
		img.setRGB(cont-2, 3, Color.BLACK.getRGB());
		img.setRGB(cont+2, 3, Color.BLACK.getRGB());
		
		img.setRGB(cont-1, 4, Color.BLACK.getRGB());
		img.setRGB(cont, 4, Color.BLACK.getRGB());
		img.setRGB(cont+1, 4, Color.BLACK.getRGB());
		
		
		File outputfile=new File("C:/Users/Asus/Documents/EIA/Compi/Compilador/PruebaIMG.jpg");
		try {
			ImageIO.write(img, "png", outputfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	

}
}
