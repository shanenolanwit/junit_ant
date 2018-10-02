package shane.nolan.wit;

import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")
public class PhoneBox<T> extends ArrayList<T> {
	
	private final int limit;
	
	public PhoneBox(int limit) {
		super(limit);
		this.limit = limit;
	}

	public int getLimit() {
		return limit;
	}

	@Override
	public boolean add(T e) {
		boolean result = false;
		if(this.size() < this.limit){
			result = super.add(e);
		}
		return result;
	}

	@Override
	public void add(int index, T element) {
		if(this.size() < this.limit){
			super.add(index,element);
		}
	}

	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean result = false;
		if(this.size() + c.size() < this.limit){
			result = super.addAll(c);
		}
		return result;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c) {
		boolean result = false;
		if(this.size() + c.size() < this.limit){
			result = super.addAll(index,c);
		}
		return result;
	}
	
	
	

}
