package com.example.spring.basic02;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;



public class Sample01{


	private Map map;
	private Properties props;	
	private Set set;
	private List list;
	
	
	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Properties getProps() {
		return props;
	}

	public void setProps(Properties props) {
		this.props = props;
	}

	public Set getSet() {
		return set;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}


	public static void main(String[] args){

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("basic02/sample01.xml"));
		Sample01 instance = (Sample01)factory.getBean("sample01");

		instance.displayInfo();

	} //main

		public void displayInfo(){
			//disply the Map

			Iterator i = map.keySet().iterator();

			System.out.println("\n Map 내용: \n");

			while(i.hasNext()){
				Object key = i.next();
				System.out.println("\nKey:" + key + "- value : " + map.get(key));
			}

			//display the properties
			i = props.keySet().iterator();
			System.out.println("\n Properties 내용:\n");

			while(i.hasNext()){

				String key = i.next().toString();
				System.out.println("Key:" + key + "- Value :" + props.getProperty(key));


				//display the 
				i = set.iterator();
				System.out.println("\n Set 내용 : \n");
				while(i.hasNext()){
					System.out.println("Value : " + i.next());

					i = list.iterator();
					System.out.println("\n List 내용 : \n");

					while(i.hasNext()){
						System.out.println("Value:" + i.next());
					}
				}
			}

		} //displayInfo()
	
	}