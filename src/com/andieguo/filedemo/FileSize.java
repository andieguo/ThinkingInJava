package com.andieguo.filedemo;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;

public class FileSize {
	// bt�ֽڲο���
	public static final long SIZE_BT = 1024L;
	// KB�ֽڲο���
	public static final long SIZE_KB = SIZE_BT * 1024L;
	// MB�ֽڲο���
	public static final long SIZE_MB = SIZE_KB * 1024L;
	// GB�ֽڲο���
	public static final long SIZE_GB = SIZE_MB * 1024L;
	// TB�ֽڲο���
	public static final long SIZE_TB = SIZE_GB * 1024L;
	public static final int SACLE = 2;

	// �ļ�����
	private File file;
	// �ļ���С����
	private long longSize;

	public FileSize(File file) {
		this.file = file;
	}

	// �����ļ���С
	private void getFileSize() throws RuntimeException, IOException {
		// ��ʼ���ļ���СΪ0��
		this.longSize = 0;

		// ����ļ����ڶ������ļ���ֱ�ӷ����ļ���С
		if (file.exists() && file.isFile()) {
			this.longSize = file.length();

			// �ļ����ڶ�����Ŀ¼���ݹ�����ļ�Ŀ¼�����ļ���С
		} else if (file.exists() && file.isDirectory()) {
			getFileSize(file);// �ݹ����
		} else {
			throw new RuntimeException("ָ���ļ�������");
		}
	}

	// �ݹ�����ļ�Ŀ¼�����ļ���С
	private void getFileSize(File file) throws RuntimeException, IOException {
		// ����ļ�Ŀ¼���ļ���������
		File[] fileArray = file.listFiles();
		// ����ļ�Ŀ¼���鲻Ϊ�ջ���length!=0,��Ŀ¼Ϊ��Ŀ¼
		if (fileArray != null && fileArray.length != 0) {
			// �����ļ���������
			for (int i = 0; i < fileArray.length; i++) {
				File fileSI = fileArray[i];
				// �����Ŀ¼�ݹ����
				if (fileSI.isDirectory()) {
					// �ݹ����
					getFileSize(fileSI);
				}
				// ������ļ�
				if (fileSI.isFile()) {
					this.longSize += fileSI.length();
				}
			}
		} else {
			// ����ļ�Ŀ¼����Ϊ�ջ���length==0,��Ŀ¼Ϊ��Ŀ¼
			this.longSize = 0;
		}
	}

	public String toString() throws RuntimeException {
		try {
			// ���ü����ļ���Ŀ¼��С����
			getFileSize();

			if (this.longSize >= 0 && this.longSize < SIZE_BT) {
				return this.longSize + "B";
			} else if (this.longSize >= SIZE_BT && this.longSize < SIZE_KB) {
				return this.longSize / SIZE_BT + "KB";
			} else if (this.longSize >= SIZE_KB && this.longSize < SIZE_MB) {
				return this.longSize / SIZE_KB + "MB";
			} else if (this.longSize >= SIZE_MB && this.longSize < SIZE_GB) {
				BigDecimal longs = new BigDecimal(Double.valueOf(
						this.longSize + "").toString());
				BigDecimal sizeMB = new BigDecimal(Double.valueOf(SIZE_MB + "")
						.toString());
				String result = longs.divide(sizeMB, SACLE,
						BigDecimal.ROUND_HALF_UP).toString();
				// double result=this.longSize/(double)SIZE_MB;
				return result + "GB";
			} else {
				BigDecimal longs = new BigDecimal(Double.valueOf(
						this.longSize + "").toString());
				BigDecimal sizeMB = new BigDecimal(Double.valueOf(SIZE_GB + "")
						.toString());
				String result = longs.divide(sizeMB, SACLE,
						BigDecimal.ROUND_HALF_UP).toString();
				return result + "TB";
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public long getLongSize() throws RuntimeException {
		try {
			// ���ü����ļ���Ŀ¼��С����
			getFileSize();
			return longSize;
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex.getMessage());
		}
	}
}
