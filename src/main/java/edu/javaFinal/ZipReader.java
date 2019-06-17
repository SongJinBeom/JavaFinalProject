package edu.javaFinal;

import java.io.File;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipFile;

public class ZipReader {

	ArrayList<String> result;
	ArrayList<ZipFile> zipFiles;
	HashMap<String, ArrayList<String>> datas;

	ZipReader() {
		this.zipFiles = new ArrayList<ZipFile>();
		this.result = new ArrayList<String>();
		this.datas = new HashMap<String, ArrayList<String>>();
	}

	public HashMap<String, ArrayList<String>> searchFiles(String source) {

		File dir = new File(source);
		ZipFile zipFile;
		File[] fileList = dir.listFiles();
		String key = "";

		try {
			for (int i = 0; i < fileList.length; i++) {
				File file = fileList[i];
				if (file.isFile()) {
					// 파일이 있다면 파일 이름 출력

					System.out.println("파일 이름 = " + file.getName());

					zipFile = new ZipFile(file);
					int count = 1;

					try {
						Enumeration<? extends ZipArchiveEntry> entries = zipFile.getEntries();

						while (entries.hasMoreElements()) {
							ZipArchiveEntry entry = entries.nextElement();
							InputStream stream = zipFile.getInputStream(entry);

							ExcelReader myReader = new ExcelReader();

							if (count % 2 == 1) {
								key = key + file.getName().substring(0, 4) + "-" + count;
								System.out.println(key);
								datas.put(key, myReader.getData1(stream));

							} else {
								key = key + file.getName().substring(0, 4) + "-" + count;
								System.out.println(key);
								datas.put(key, myReader.getData2(stream));
							}
							count++;
							if (count == 3) {
								count = 1;
							}
							key = "";
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					zipFiles.add(zipFile);
				} else if (file.isDirectory()) {
					System.out.println("디렉토리 이름 = " + file.getName());
					searchFiles(file.getCanonicalPath().toString());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return datas;
	}


}