JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	client/Client.java \
	client/ClientCommandLine.java \
	client/ClientGUI.java \
	client/MatchInfoView.java \
	client/ScouterMessage.java \
	client/SelectionWindow.java \
	client/SetupView.java \
	enums/Alliance.java \
	enums/ScoreType.java \
	server/ClientConfig.java \
	server/ScoutServer.java \
	serverDataBase/Match.java \
	serverDataBase/MatchList.java \
	serverDataBase/MatchScore.java \
	serverDataBase/OpSwitch.java \
	serverDataBase/Scale.java \
	serverDataBase/Score.java \
	serverDataBase/Switch.java \
	serverDataBase/Team.java \
	serverDataBase/TeamSheet.java \
	serverDataBase/Tournament.java \
	serverDataBase/Vault.java 

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class