public class StoreAttenededTemp {
	/* here i try to store the students who attended 
	 * the classes for this session.
	 */
	public StoreAttenededTemp(boolean isAbsent[]) {
		GetDatabaseConnection conObj = new GetDatabaseConnection();
		conObj.getMyConnection("temp");
	}
}