package site.metacoding.practice;



/**
 * 
 * @author �ƶ�
 * ������ �������~~~~~~~~~~~~~~~~~~~~~~~~
 * initObject 1�� ����
 * initSetting 2������
 * initListener 3�� ���� (default)*/


public interface Init {
	void initObject();
	void initSetting();
	default void initListener() {}; 
	
	
}
