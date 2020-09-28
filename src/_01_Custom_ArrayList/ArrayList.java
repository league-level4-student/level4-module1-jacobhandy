package _01_Custom_ArrayList;

@SuppressWarnings("unchecked")

public class ArrayList <T>{
    T[] object;

	public ArrayList() {
		//object = null;
		object = (T[]) new Object[0];
	}
	
	public T get(int loc) throws IndexOutOfBoundsException {
		return object[loc];
	}
	
	public void add(T val) {
		T[] newObject = (T[]) new Object[object.length + 1];
		for(int a = 0; a < newObject.length; a++) {
			try {
			newObject[a] = object[a];
			}
			catch(Exception e) {
				
			}
		}
		newObject[newObject.length - 1] = val;
		object = newObject;
	}
	
	public void insert(int loc, T val) throws IndexOutOfBoundsException {
		T[] newObject = (T[]) new Object[object.length + 1];
		for(int a = 0; a < newObject.length; a++) {
			int b = a + 1;
			try {
				if(a < loc) {
					newObject[a] = object[a];
				}
				else if(a > loc) {
					newObject[b] = object[a];
				}
			}
			catch(Exception e) {
				
			}
		}
		newObject[loc] = val;
		for(int a = 0; a < newObject.length; a++) {
			System.out.println(newObject[a]);
		}
		object = newObject;
	}
	
	public void set(int loc, T val) throws IndexOutOfBoundsException {
		object[loc] = val;
		
	}
	
	public void remove(int loc) throws IndexOutOfBoundsException {
		//come back to insert
		T[] newObject = (T[]) new Object[object.length - 1];
		for(int a = 0; a < newObject.length; a++) {
			try {
			if(a < loc) {
				newObject[a] = object[a];
			}
			else {
				newObject[a] = object[a-1];
			}
			}
			catch(Exception e) {
				
			}
		}
		for(int a = 0; a < newObject.length; a++) {
			System.out.println(newObject[a]);
		}
		object = newObject;
	}
	
	public boolean contains(T val) {
		for(int a = 0; a < object.length; a++) {
			if(object[a] == val) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		// TODO Auto-generated method stub
		return object.length;
	}
}