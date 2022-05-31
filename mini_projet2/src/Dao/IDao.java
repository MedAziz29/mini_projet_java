package Dao;


	import java.util.List;

	public interface IDao <T> {
		boolean add (T o);
		boolean delete (T o);
		boolean update (T o);
	   T findByMat(int mat);
			List <T> findAll();
			
}
