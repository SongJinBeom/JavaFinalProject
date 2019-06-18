package edu.javaFinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

public class JavaFinal {

	String inputPath;
	String outputPath;
	boolean help;

	public void execute(String[] args) {

		Options options = createOptions();
		HashMap<String, ArrayList<String>> allExcels;
		HashMap<String, ArrayList<String>> excel1 = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> excel2 = new HashMap<String, ArrayList<String>>();

		ArrayList<String> toBeMerged = new ArrayList<String>();
		ArrayList<String> merged1 = new ArrayList<String>();
		ArrayList<String> merged2 = new ArrayList<String>();

		String category1 = "StdID,제목,요약문(300자 내외),핵심어(keyword,쉼표로 구분),조회날짜,"
				+ "실제자료조회 출처(웹 자료링크),원출처 (기관명 등),제작자(Copyright 소유)";
		String category2 = "StdId,제목(반드시 요약문 양식에 입력한 제목과 같아야함.), 표/그림 일련번호, 자료유형(표,그림...), "
				+ "자료에 나온 표나 그림 설명(캡션), 자료가 나온 쪽번호";

		if (parseOptions(options, args)) {

			if (help) {
				printHelp(options);
				System.exit(0);
				return;
			}

			try {
				// when there are not enough arguments from CLI, it throws the
				// NotEnoughArgmentException which must be defined by you.
				if (args.length < 4)
					throw new NotEnoughArgumentException();

			} catch (NotEnoughArgumentException e) {
				System.out.println(e.getMessage());
				System.exit(0);
			}

			String dataPath = inputPath;
			System.out.println(dataPath);
			String resultPath = outputPath;

			ZipReader read = new ZipReader();
			allExcels = read.searchFiles(inputPath);
			Map<String, ArrayList<String>> sortedExcels = new TreeMap<String, ArrayList<String>>(allExcels);

			String k = "";

			for (String temp : sortedExcels.keySet()) {

				if (temp.endsWith("1")) {
					k = temp.substring(0, 4);
					toBeMerged = sortedExcels.get(temp);
					// System.out.println(toBeMerged.get(2));
					excel1.put(k, toBeMerged);
				} else {
					k = temp.substring(0, 4);
					toBeMerged = sortedExcels.get(temp);
					excel2.put(k, toBeMerged);
				}
				// System.out.println(k);

			}
		}

		Map<String, ArrayList<String>> sorted1 = new TreeMap<String, ArrayList<String>>(excel1);
		Map<String, ArrayList<String>> sorted2 = new TreeMap<String, ArrayList<String>>(excel2);

		ArrayList<String> t = new ArrayList<String>();

		merged1.add(category1);
		SummaryData sd1;
		for (String temp : sorted1.keySet()) {
			t = sorted1.get(temp);
			for (String tempString : t) {
				sd1 = new SummaryData(tempString, temp);
				merged1.add(sd1.getFullInfo());
				// System.out.println(sd1.getFullInfo());
			}
		}

		for (String k : merged1) {
			//System.out.println(k);
		}

		merged2.add(category2);

		ChartData cd1;
		for (String temp : sorted2.keySet()) {
			t = sorted2.get(temp);
			for (String tempString : t) {
				cd1 = new ChartData(tempString, temp);
				merged2.add(cd1.getFullInfo());
				// System.out.println(cd1.getFullInfo());
			}
		}

		for (String k : merged2) {
			//System.out.println(k);
		}

		// WriteFiles w1 = new WriteFiles(merged1, merged2, outputPath);
		ExcelWriter e1 = new ExcelWriter();
		e1.writeAFile(merged1, outputPath, 1);
		e1.writeAFile(merged2, outputPath, 2);
	}

	private Options createOptions() {

		Options options = new Options();

		options.addOption(Option.builder("i").longOpt("input").desc("Set an input file path").hasArg()
				.argName("Input Path").required().build());

		options.addOption(Option.builder("o").longOpt("output").desc("Set an output file path").hasArg()
				.argName("Output Path").required().build());

		options.addOption(
				Option.builder("h").longOpt("help").desc("Show a Help page").argName("Path name to display").build());

		return options;
	}

	private boolean parseOptions(Options options, String[] args) {
		CommandLineParser parser = new DefaultParser();
		try {
			CommandLine cmd = parser.parse(options, args);

			inputPath = cmd.getOptionValue("i");
			outputPath = cmd.getOptionValue("o");
			help = cmd.hasOption("h");

		} catch (Exception e) {
			printHelp(options);
			return false;
		}

		return true;
	}

	private void printHelp(Options options) {
		// TODO Auto-generated method stub
		HelpFormatter formatter = new HelpFormatter();
		String header = "Java Final Project";
		String footer = "";
		formatter.printHelp("CLIExample", header, options, footer, true);
	}

}
