package stringexp;
import java.util.regex.*; 

public class poem {
	public static void main(String[] args) {
		//定义字符串
		String ss = "汉皇重色思倾国御宇多年求不得杨家有女初长成养在深闺人未识天生丽质难自弃一朝选在君王侧"
				  + "回眸一笑百媚生六宫粉黛无颜色春寒赐浴华清池温泉水滑洗凝脂侍儿扶起娇无力始是新承恩泽时"
				  + "云鬓花颜金步摇芙蓉帐暖度春宵春宵苦短日高起从此君王不早朝承欢侍宴无闲暇春从春游夜专夜"
				  + "后宫佳丽三千人三千宠爱在一身金屋妆成娇侍夜玉楼宴罢醉和春姊妹弟兄皆列土可怜光彩生门户"
				  + "遂令天下父母心不重生男重生女骊宫高处入青云仙乐风飘处处闻缓歌慢舞凝丝竹尽日君王看不足"
				  + "渔阳鼙鼓动地来惊破霓裳羽衣曲九重城阙烟尘生千乘万骑西南行翠华摇摇行复止西出都门百余里"
				  + "六军不发无奈何宛转蛾眉马前死花钿委地无人收翠翘金雀玉搔头君王掩面救不得回看血泪相和流 ";
		
		try{
		char[] chars = ss.toCharArray();//定义数组
		StringBuffer s = new StringBuffer();//追加内容到当前StringBuffer对象的末尾
		
		//计算字符串中关键字出现的次数
		countString(ss,"回眸");
		
		
		for (int i =0; i <chars.length; i++) {
			//在被选元素的结尾插入符号
			s.append(chars[i]);
		
			if ((i+1)%7==0&&(i+1)%2==1||(i+1)%14==0&&(i+1)%2==0) {
				//i%7等于0并且i为奇数时，在结尾加，
				if((i+1)%7==0&&(i+1)%2==1)
					s.append(",");
				
				//i%14等于0并且i为偶数时，在结尾加。
				else
					s.append("。\n");
			}
			}
		System.out.println(s.toString());
		}
		//异常处理
		catch(Exception   e){
			System.out.print("发生异常:"+e.toString());
			e.printStackTrace();
		}
		
	}

	private static void countString(String ss, String string) {
		// TODO Auto-generated method stub
		int count=0;
		while(ss.indexOf(string)!=-1){//查找字串中指定字符首次出现的位置
			//返回一个新字符串，它是此字符串的一个子字符串。
			ss = ss.substring(ss.indexOf(string)+1,ss.length());    
            count++;
		}
		System.out.println(string+" 出现的次数为:"+count+"次");
	}

		
	}




