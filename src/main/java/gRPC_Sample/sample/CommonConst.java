package gRPC_Sample.sample;

public class CommonConst {

	public static final int PORT = 50051;
	public static final String HOST = "localhost";

	// Client Setting
	public static final int THREAD_COUNT = 3;
	public static final String SEND_FILE_NAME = "testfile_300m_";

//	public static final int FILE_SPLIT_UNIT = 4194304; // 4MB
//	public static final int FILE_SPLIT_UNIT = 2097152; // 2MB
//	public static final int FILE_SPLIT_UNIT = 3145728; // 3MB
//	public static final int FILE_SPLIT_UNIT = 3670016; // 3.5MB‬
//	public static final int FILE_SPLIT_UNIT = 3932160; // 3.75MB‬

	public static final int FILE_SPLIT_UNIT = 4194276; // 4MB - 20B
}
