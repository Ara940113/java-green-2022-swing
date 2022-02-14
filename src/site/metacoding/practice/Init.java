package site.metacoding.practice;



/**
 * 
 * @author 아라
 * 생성자 실행순서~~~~~~~~~~~~~~~~~~~~~~~~
 * initObject 1번 실행
 * initSetting 2번실행
 * initListener 3번 실행 (default)*/


public interface Init {
	void initObject();
	void initSetting();
	default void initListener() {}; 
	
	
}
