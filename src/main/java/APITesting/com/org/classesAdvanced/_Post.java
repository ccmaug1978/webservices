package APITesting.com.org.classesAdvanced;

import APITesting.com.org.classes.info;

public class _Post {
	
	private String id;
	private String author;
	private String title;
	private _info[] Info;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public _info[] getInfo()
	{
		return Info;
	}
	public void setInfo(_info[] _infos)
	{
		this.Info=_infos;
	}

	
}
