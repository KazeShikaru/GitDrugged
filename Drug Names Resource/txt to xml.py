with open("drug_names lower trimmed1 sorted.txt", "r") as reader:
    lines_in = reader.readlines()

#remove newline from list elements
lines = []
for x in lines_in:
    lines.append(x.replace("\n",""))

with open("Drug_Names.xml","a") as writer:
    writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n")
    writer.write("<resources>\n")
    writer.write("\t<string-array name=\"drug_names\">\n")
    for x in lines:
        writer.write("\t\t<item>" + x + "</item>\n")
    writer.write("\t</string-array>\n")
    writer.write("</resources>\n")