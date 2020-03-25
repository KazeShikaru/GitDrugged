with open("drug_names lower trimmed1.txt", "r") as reader:
    lines = reader.readlines()

lines.sort()
with open("drug_names lower trimmed1 sorted.txt","a") as writer:
    for x in lines:
        writer.write(x)