package com.syh.xmlpullparser;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import android.util.Xml;

public class Xmlpullparser {
	/**
	 * 使用pull方式解析xml文件 Tile:pullParser Desciption:
	 * 
	 * @return List<SmsInfoBean> 解析出来的数据集
	 * @throws XmlPullParserException
	 */
	private List<SmsInfoBean> smsinfos;
	private SmsInfoBean smsInfoBean;
	public List<SmsInfoBean> pullParser(InputStream is) throws Exception {
		XmlPullParser parser = Xml.newPullParser();
		// 初始化解析器
		parser.setInput(is, "utf-8");
		//获取标签指针
		int type = parser.getEventType();
		
		while (type != XmlPullParser.END_DOCUMENT) {

			switch (type) {
			case XmlPullParser.START_TAG:
				parserStartTags(parser);
				break;
			case XmlPullParser.END_TAG:
				// 一个单元组的数据信息已经读取完毕
				if ("sms".equals(parser.getName())) {
					smsinfos.add(smsInfoBean);
					smsInfoBean = null;
				}
				break;
			default:
				break;
			}

			type = parser.next();
		}
		return smsinfos;
	}
	/**
	 * 解析开始标签名
	 *Tile:parserStartTags
	 *Desciption:
	 * @param parser
	 * @throws Exception
	 * void
	 */
	private void parserStartTags(XmlPullParser parser)
			throws Exception {
		// 需要解析的组的开始标签
		if ("smss".equals(parser.getName())) {
			smsinfos = new ArrayList<SmsInfoBean>();
			// 一个单元组的开始
		} else if ("sms".equals(parser.getName())) {
			smsInfoBean = new SmsInfoBean();
		} else if ("body".equals(parser.getName())) {
			String bodyValue = parser.nextText();
			smsInfoBean.setBody(bodyValue);
		} else if ("type".equals(parser.getName())) {
			String typeValue = parser.nextText();
			smsInfoBean.setType(Integer.parseInt(typeValue));
		} else if ("adress".equals(parser.getName())) {
			String adressValue = parser.nextText();
			smsInfoBean.setAdress(Long.parseLong(adressValue));
		} else if ("data".equals(parser.getName())) {
			String dataValue = parser.nextText();
			smsInfoBean.setData(Long.parseLong(dataValue));
		}
	}
}
