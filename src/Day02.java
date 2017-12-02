import java.util.Arrays;

public class Day02 {

	public static void main(String[] args) {
		
		/*
		 * The spreadsheet consists of rows of apparently-random numbers. 
		 * To make sure the recovery process is on the right track, they 
		 * need you to calculate the spreadsheet's checksum. For each row, 
		 * determine the difference between the largest value and the smallest 
		 * value; the checksum is the sum of all of these differences.
		 */
		
		/*
		 * It sounds like the goal is to find the only two numbers in each 
		 * row where one evenly divides the other - that is, where the result 
		 * of the division operation is a whole number. They would like you 
		 * to find those numbers on each line, divide them, and add up each 
		 * line's result.
		 */
		
		String input = "3751	3769	2769	2039	2794	240	3579	1228	4291	220	324	3960	211	1346	237	1586\n" + 
				"550	589	538	110	167	567	99	203	524	288	500	111	118	185	505	74\n" + 
				"2127	1904	199	221	1201	250	1119	377	1633	1801	2011	1794	394	238	206	680\n" + 
				"435	1703	1385	1461	213	1211	192	1553	1580	197	571	195	326	1491	869	1282\n" + 
				"109	104	3033	120	652	2752	1822	2518	1289	1053	1397	951	3015	3016	125	1782\n" + 
				"2025	1920	1891	99	1057	1909	2237	106	97	920	603	1841	2150	1980	1970	88\n" + 
				"1870	170	167	176	306	1909	1825	1709	168	1400	359	817	1678	1718	1594	1552\n" + 
				"98	81	216	677	572	295	38	574	403	74	91	534	662	588	511	51\n" + 
				"453	1153	666	695	63	69	68	58	524	1088	75	1117	1192	1232	1046	443\n" + 
				"3893	441	1825	3730	3660	115	4503	4105	3495	4092	48	3852	132	156	150	4229\n" + 
				"867	44	571	40	884	922	418	328	901	845	42	860	932	53	432	569\n" + 
				"905	717	162	4536	4219	179	990	374	4409	4821	393	4181	4054	4958	186	193\n" + 
				"2610	2936	218	2552	3281	761	204	3433	3699	2727	3065	3624	193	926	1866	236\n" + 
				"2602	216	495	3733	183	4688	2893	4042	3066	3810	189	4392	3900	4321	2814	159\n" + 
				"166	136	80	185	135	78	177	123	82	150	121	145	115	63	68	24\n" + 
				"214	221	265	766	959	1038	226	1188	1122	117	458	1105	1285	1017	274	281\n" + 
				"";
		
		int checksum = 0;
		
		String[] lines = input.split("\n");
		
		for (int i = 0; i < lines.length; i++) {
			String[] tokens = lines[i].split("\t");
			int[] num = new int[tokens.length];
			
			for (int j = 0; j < num.length; j++) {
				try {
					num[j] = Integer.parseInt(tokens[j]);
				} catch (Exception e) {
					System.out.println("Not a number: " + tokens[j]);
				}
			}
			
			Arrays.sort(num);
			
			for (int j = 0; j < num.length; j++) {
				for (int k = j+1; k < num.length; k++) {
					if (num[k] % num[j] == 0) {
						checksum += (num[k] / num[j]);
						break;
					}
				}
			}
		}
		
		System.out.println(checksum);
	}

}
