while(True):
        nemo = input()
        if nemo == "EOI": break
        if nemo.lower().find("nemo") != -1: print("Found")
        else: print("Missing")
