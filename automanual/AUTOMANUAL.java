/* Generated by opensource COBOL 4J 1.1.1 */
import java.io.UnsupportedEncodingException;
import jp.osscons.opensourcecobol.libcobj.*;
import jp.osscons.opensourcecobol.libcobj.common.*;
import jp.osscons.opensourcecobol.libcobj.data.*;
import jp.osscons.opensourcecobol.libcobj.exceptions.*;
import jp.osscons.opensourcecobol.libcobj.termio.*;
import jp.osscons.opensourcecobol.libcobj.call.*;
import jp.osscons.opensourcecobol.libcobj.file.*;
import jp.osscons.opensourcecobol.libcobj.ui.*;
import java.util.Optional;
import java.lang.NullPointerException;
import java.lang.IndexOutOfBoundsException;

public class AUTOMANUAL implements CobolRunnable {

  private boolean initialized = false;
  private CobolModule cobolCurrentModule;
  private CobolModule module;
  private int entry;

  private CobolRunnable cob_unifunc;


  @Override
  public int run(CobolDataStorage... argStorages) {
    return AUTOMANUAL_(0, argStorages);
  }

  @Override
  public void cancel() {
    AUTOMANUAL_(-1);
  }

  @Override
  public boolean isActive() {
    return false;
  }

  public CobolResultSet execute () {
    int returnCode = run_module(0);
    return new CobolResultSet(returnCode);
  }

  public int AUTOMANUAL_ (int entry, CobolDataStorage ...argStorages) {
    this.entry = entry;
    return this.run_module(entry);
  }

  int run_module (int entry) {
    this.module = new CobolModule(null, null, null, null, 0, '.', '$', ',', 1, 1, 1, 0, null );

    /* Start of function code */

    /* CANCEL callback handling */
    if (entry < 0) {
    	if (!this.initialized) {
    		CobolDecimal.cobInitNumeric();
    		return 0;
    	}
    	h_OLDFILE.close (0, null);
    	h_NEWFILE.close (0, null);
    	this.initialized = false;
    	return 0;
    }

    /* Push module stack */
    CobolModule.push (module);

    /* Initialize program */
    if (!this.initialized) {
      module.setProgramId("AUTOMANUAL");

      b_RETURN_CODE.set((int)0);
      b_OLD_STS.fillBytes(' ', 2);
      b_NEW_STS.fillBytes(' ', 2);
      b_OLD_FILE_PATH.fillBytes(' ', 256);
      b_NEW_FILE_PATH.fillBytes(' ', 256);
      b_WRK_STRING.fillBytes(' ', 250);
      b_MD_CURRENT.fillBytes(' ', 250);
      b_MD_PREVIOUS.fillBytes(' ', 250);
      b_MD_NEXT.fillBytes(' ', 250);
      b_END_FLG.setByte('0');

      h_OLDFILE = CobolFileFactory.makeCobolFileInstance(
      /* select_name = */ "OLDFILE",
      /* file_status = */ h_OLDFILE_status,
      /* assign = */ f_OLD_FILE_PATH,
      /* record = */ f_OLDFILE_record,
      /* record_size = */ null,
      /* record_min = */ 0,
      /* record_max = */ 50000,
      /* nkeys = */ 0,
      /* keys = */ null,
      /* organization = */ (char)1,
      /* access_mode = */ (char)1,
      /* lock_mode = */ (char)0,
      /* open_mode = */ (char)0,
      /* flag_optional = */ false,
      /* last_open_mode = */ (char)0,
      /* special = */ (char)0,
      /* flag_nonexistent = */ false,
      /* flag_end_of_file = */ false,
      /* flag_begin_of_file = */ false,
      /* flag_first_read = */ (char)0,
      /* flag_read_done = */ false,
      /* flag_select_features = */ (char)1,
      /* flag_needs_nl = */ false,
      /* flag_needs_top = */ false,
      /* file_version = */ (char)0
      );
      h_NEWFILE = CobolFileFactory.makeCobolFileInstance(
      /* select_name = */ "NEWFILE",
      /* file_status = */ h_NEWFILE_status,
      /* assign = */ f_NEW_FILE_PATH,
      /* record = */ f_NEWFILE_record,
      /* record_size = */ null,
      /* record_min = */ 0,
      /* record_max = */ 50000,
      /* nkeys = */ 0,
      /* keys = */ null,
      /* organization = */ (char)1,
      /* access_mode = */ (char)1,
      /* lock_mode = */ (char)0,
      /* open_mode = */ (char)0,
      /* flag_optional = */ false,
      /* last_open_mode = */ (char)0,
      /* special = */ (char)0,
      /* flag_nonexistent = */ false,
      /* flag_end_of_file = */ false,
      /* flag_begin_of_file = */ false,
      /* flag_first_read = */ (char)0,
      /* flag_read_done = */ false,
      /* flag_select_features = */ (char)1,
      /* flag_needs_nl = */ false,
      /* flag_needs_top = */ false,
      /* file_version = */ (char)0
      );

      this.initialized = true;
    }
    /* PROCEDURE DIVISION */
    try{
      CobolStopRunException.dummy();
      CobolGoBackException.dummy();
      /* Entry dispatch */
      execEntry(l_AUTOMANUAL);

    } catch(CobolGoBackException e) {
      return e.getReturnCode();
    } catch(CobolStopRunException e) {
      CobolStopRunException.stopRun();
      System.exit(e.getReturnCode());
    }
    /* Pop module stack */
    CobolModule.pop();

    /* Program return */
    return b_RETURN_CODE.intValue();
  }
  public CobolControl[] contList = {
    new CobolControl(0, CobolControl.LabelType.label) {
      public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

        return Optional.of(contList[l_AUTOMANUAL]);
      }
    },
    /* Entry AUTOMANUAL */
    new CobolControl(l_AUTOMANUAL, CobolControl.LabelType.label) {
      public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

        return Optional.of(contList[l_MAIN_CONTROL]);
      }
    },
    /* MAIN-CONTROL SECTION */
    new CobolControl(l_MAIN_CONTROL, CobolControl.LabelType.section) {
      public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

        return Optional.of(contList[l_MAIN_CONTROL__MAIN_000]);
      }
    },
    /* MAIN-000 */
    new CobolControl(l_MAIN_CONTROL__MAIN_000, CobolControl.LabelType.label) {
      public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {
        /* AUTOMANUAL.cbl:51: ACCEPT */
        {
          CobolTerminal.acceptCommandLine (f_WRK_STRING);
        }
        /* AUTOMANUAL.cbl:52: UNSTRING */
        {
          CobolString.unstringInit (f_WRK_STRING, 0, 1);
          CobolString.unstringDelimited (CobolConstant.space, 0);
          CobolString.unstringInto (f_MD_CURRENT, 0, 0);
          CobolString.unstringInto (f_MD_PREVIOUS, 0, 0);
          CobolString.unstringInto (f_MD_NEXT, 0, 0);
          CobolString.unstringFinish ();
        }
        /* AUTOMANUAL.cbl:58: IF */
        {
          if (((long)f_MD_PREVIOUS.compareTo (c_1_none) == 0L))
            {
              /* AUTOMANUAL.cbl:59: MOVE */
              {
                b_MD_PREVIOUS.fillBytes (32, 250);
              }
            }
        }
        /* AUTOMANUAL.cbl:60: IF */
        {
          if (((long)f_MD_NEXT.compareTo (c_1_none) == 0L))
            {
              /* AUTOMANUAL.cbl:61: MOVE */
              {
                b_MD_NEXT.fillBytes (32, 250);
              }
            }
        }
        /* AUTOMANUAL.cbl:63: MOVE */
        {
          b_OLD_FILE_PATH.fillBytes (32, 256);
        }
        /* AUTOMANUAL.cbl:64: STRING */
        {
          CobolString.stringInit (f_OLD_FILE_PATH, 0);
          CobolString.stringDelimited (0);
          CobolString.stringAppend (c_2_old);
          CobolString.stringDelimited (CobolConstant.space);
          CobolString.stringAppend (f_MD_CURRENT);
          CobolString.stringFinish ();
        }
        /* AUTOMANUAL.cbl:67: MOVE */
        {
          b_NEW_FILE_PATH.fillBytes (32, 256);
        }
        /* AUTOMANUAL.cbl:68: STRING */
        {
          CobolString.stringInit (f_NEW_FILE_PATH, 0);
          CobolString.stringDelimited (0);
          CobolString.stringAppend (c_3_new);
          CobolString.stringDelimited (CobolConstant.space);
          CobolString.stringAppend (f_MD_CURRENT);
          CobolString.stringFinish ();
        }
        /* AUTOMANUAL.cbl:72: IF */
        {
          if (((long)f_OLD_FILE_PATH.compareTo (CobolConstant.space) == 0L))
            {
              /* AUTOMANUAL.cbl:72: GO TO */
              {
                if(true) return Optional.of(contList[l_MAIN_CONTROL__MAIN_900                ]);

              }
            }
        }
        /* AUTOMANUAL.cbl:74: OPEN */
        {
          CobolRuntimeException.code = 0;
          {
            h_OLDFILE.open (1, 0, f_OLD_STS);
          }
          if (CobolRuntimeException.code != 0)
            {
              /* PERFORM Default Error Handler */
              CobolControl.perform(contList, l_Default_Error_Handler).run();
            }
          CobolRuntimeException.code = 0;
          {
            h_NEWFILE.open (2, 1, f_NEW_STS);
          }
          if (CobolRuntimeException.code != 0)
            {
              /* PERFORM Default Error Handler */
              CobolControl.perform(contList, l_Default_Error_Handler).run();
            }
        }
        /* AUTOMANUAL.cbl:79: WRITE */
        CobolRuntimeException.code = 0;
        {
          f_NEW_REC.moveFrom (c_4);
          h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
        }
        if (CobolRuntimeException.code != 0)
          {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, l_Default_Error_Handler).run();
          }
        /* AUTOMANUAL.cbl:83: MOVE */
        {
          b_NEW_REC.fillBytes (32, 50000);
        }
        /* AUTOMANUAL.cbl:84: IF */
        {
          if ((((long)f_MD_PREVIOUS.compareTo (CobolConstant.space) != 0L) && ((long)f_MD_NEXT.compareTo (CobolConstant.space) != 0L)))
            {
              /* AUTOMANUAL.cbl:85: STRING */
              {
                CobolString.stringInit (f_NEW_REC, 0);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_5);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_6);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (f_MD_PREVIOUS);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_8);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_9);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (c_10_https);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (c_11_github);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_8);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_12);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (f_MD_NEXT);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_13);
                CobolString.stringFinish ();
              }
              /* AUTOMANUAL.cbl:102: WRITE */
              CobolRuntimeException.code = 0;
              {
                h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
              }
              if (CobolRuntimeException.code != 0)
                {
                  /* PERFORM Default Error Handler */
                  CobolControl.perform(contList, l_Default_Error_Handler).run();
                }
            }
        }
        /* AUTOMANUAL.cbl:103: IF */
        {
          if (((long)f_MD_PREVIOUS.compareTo (CobolConstant.space) == 0L))
            {
              /* AUTOMANUAL.cbl:104: STRING */
              {
                CobolString.stringInit (f_NEW_REC, 0);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_6);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_14);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_9);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (c_10_https);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (c_11_github);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_8);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_12);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (f_MD_NEXT);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_13);
                CobolString.stringFinish ();
              }
              /* AUTOMANUAL.cbl:118: WRITE */
              CobolRuntimeException.code = 0;
              {
                h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
              }
              if (CobolRuntimeException.code != 0)
                {
                  /* PERFORM Default Error Handler */
                  CobolControl.perform(contList, l_Default_Error_Handler).run();
                }
            }
        }
        /* AUTOMANUAL.cbl:119: IF */
        {
          if (((long)f_MD_NEXT.compareTo (CobolConstant.space) == 0L))
            {
              /* AUTOMANUAL.cbl:120: STRING */
              {
                CobolString.stringInit (f_NEW_REC, 0);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_5);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_6);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (f_MD_PREVIOUS);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_8);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_9);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_7);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (c_10_https);
                CobolString.stringDelimited (CobolConstant.space);
                CobolString.stringAppend (c_11_github);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_15);
                CobolString.stringDelimited (0);
                CobolString.stringAppend (c_12);
                CobolString.stringFinish ();
              }
              /* AUTOMANUAL.cbl:134: WRITE */
              CobolRuntimeException.code = 0;
              {
                h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
              }
              if (CobolRuntimeException.code != 0)
                {
                  /* PERFORM Default Error Handler */
                  CobolControl.perform(contList, l_Default_Error_Handler).run();
                }
            }
        }
        /* AUTOMANUAL.cbl:137: WRITE */
        CobolRuntimeException.code = 0;
        {
          f_NEW_REC.moveFrom (c_16);
          h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
        }
        if (CobolRuntimeException.code != 0)
          {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, l_Default_Error_Handler).run();
          }
        /* AUTOMANUAL.cbl:142: WRITE */
        CobolRuntimeException.code = 0;
        {
          f_NEW_REC.moveFrom (c_17);
          h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
        }
        if (CobolRuntimeException.code != 0)
          {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, l_Default_Error_Handler).run();
          }
        /* AUTOMANUAL.cbl:145: MOVE */
        {
          b_NEW_REC.fillBytes (32, 50000);
        }
        /* AUTOMANUAL.cbl:146: WRITE */
        CobolRuntimeException.code = 0;
        {
          h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
        }
        if (CobolRuntimeException.code != 0)
          {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, l_Default_Error_Handler).run();
          }
        /* AUTOMANUAL.cbl:147: MOVE */
        {
          b_NEW_REC.fillBytes (32, 50000);
        }
        /* AUTOMANUAL.cbl:148: STRING */
        {
          CobolString.stringInit (f_NEW_REC, 0);
          CobolString.stringDelimited (0);
          CobolString.stringAppend (c_5);
          CobolString.stringDelimited (0);
          CobolString.stringAppend (c_18);
          CobolString.stringDelimited (0);
          CobolString.stringAppend (c_7);
          CobolString.stringDelimited (CobolConstant.space);
          CobolString.stringAppend (f_MD_CURRENT);
          CobolString.stringDelimited (0);
          CobolString.stringAppend (c_13);
          CobolString.stringFinish ();
        }
        /* AUTOMANUAL.cbl:155: WRITE */
        CobolRuntimeException.code = 0;
        {
          h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
        }
        if (CobolRuntimeException.code != 0)
          {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, l_Default_Error_Handler).run();
          }
        /* AUTOMANUAL.cbl:158: WRITE */
        CobolRuntimeException.code = 0;
        {
          f_NEW_REC.moveFrom (c_19);
          h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
        }
        if (CobolRuntimeException.code != 0)
          {
            /* PERFORM Default Error Handler */
            CobolControl.perform(contList, l_Default_Error_Handler).run();
          }
        /* AUTOMANUAL.cbl:159: PERFORM */
        for (;;)
          {
            if (((long)f_OLD_STS.compareTo (CobolConstant.zero) != 0L))
              break;
            {
              /* AUTOMANUAL.cbl:160: MOVE */
              {
                b_OLD_REC.fillBytes (32, 50000);
              }
              /* AUTOMANUAL.cbl:161: READ */
              CobolRuntimeException.code = 0;
              {
                h_OLDFILE.read (0, f_OLD_STS, 1);
              }
              if (CobolRuntimeException.code != 0)
                {
                  if (CobolRuntimeException.code == 0x0501)
                    {
                      {
                        /* AUTOMANUAL.cbl:163: CONTINUE */
                        {
                          ;
                        }
                      }
                    }
                  else
                    {
                      /* PERFORM Default Error Handler */
                      CobolControl.perform(contList, l_Default_Error_Handler).run();
                    }
                }
              else
                {
                  {
                    /* AUTOMANUAL.cbl:165: MOVE */
                    {
                      b_NEW_REC.setBytes (b_OLD_REC, 50000);
                    }
                    /* AUTOMANUAL.cbl:166: WRITE */
                    CobolRuntimeException.code = 0;
                    {
                      h_NEWFILE.write (f_NEW_REC, 2162689, f_NEW_STS);
                    }
                    if (CobolRuntimeException.code != 0)
                      {
                        /* PERFORM Default Error Handler */
                        CobolControl.perform(contList, l_Default_Error_Handler).run();
                      }
                  }
                }
            }
          }
        /* AUTOMANUAL.cbl:170: CLOSE */
        {
          CobolRuntimeException.code = 0;
          {
            h_NEWFILE.close (0, f_NEW_STS);
          }
          if (CobolRuntimeException.code != 0)
            {
              /* PERFORM Default Error Handler */
              CobolControl.perform(contList, l_Default_Error_Handler).run();
            }
        }
        /* AUTOMANUAL.cbl:171: CLOSE */
        {
          CobolRuntimeException.code = 0;
          {
            h_OLDFILE.close (0, f_OLD_STS);
          }
          if (CobolRuntimeException.code != 0)
            {
              /* PERFORM Default Error Handler */
              CobolControl.perform(contList, l_Default_Error_Handler).run();
            }
        }

        return Optional.of(contList[l_MAIN_CONTROL__MAIN_900]);
      }
    },
    /* MAIN-900 */
    new CobolControl(l_MAIN_CONTROL__MAIN_900, CobolControl.LabelType.label) {
      public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {
        /* AUTOMANUAL.cbl:173: STOP */
        {
          CobolStopRunException.throwException (b_RETURN_CODE.intValue());
        }


        return Optional.of(CobolControl.pure());
      }
    },
    /* Default Error Handler */
    new CobolControl(l_Default_Error_Handler, CobolControl.LabelType.label) {
      public Optional<CobolControl> run() throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {

        if ((CobolFile.errorFile.flag_select_features & CobolFile.COB_SELECT_FILE_STATUS) == 0) {
        	CobolFile.defaultErrorHandle ();
        	CobolStopRunException.stopRunAndThrow (1);
        }

        return Optional.of(CobolControl.pure());
      }
    },
    CobolControl.pure()
  };
  public void execEntry(int start) throws CobolRuntimeException, CobolGoBackException, CobolStopRunException {
    Optional<CobolControl> nextLabel = Optional.of(contList[start]);
    while(nextLabel.isPresent()) {
      CobolControl section = nextLabel.get();
      nextLabel = section.run();
    }
  }

  public static void main(String[] args)
  {
    CobolUtil.cob_init(args, false);
    CobolDecimal.cobInitNumeric();
    new AUTOMANUAL().AUTOMANUAL_(0);
    CobolStopRunException.stopRun();
  }

  public AUTOMANUAL()
  {
    init();
  }

  public void init() 
  {
    try {
      /* Data storage */

      cob_unifunc = null;

      /* PROGRAM-ID : AUTOMANUAL */
      b_RETURN_CODE = new CobolDataStorage(4);	/* RETURN-CODE */
      b_OLDFILE_record = new CobolDataStorage(50000);	/* OLDFILE_record */
      b_NEWFILE_record = new CobolDataStorage(50000);	/* NEWFILE_record */
      b_OLD_STS = new CobolDataStorage(2);	/* OLD-STS */
      b_NEW_STS = new CobolDataStorage(2);	/* NEW-STS */
      b_OLD_FILE_PATH = new CobolDataStorage(256);	/* OLD-FILE-PATH */
      b_NEW_FILE_PATH = new CobolDataStorage(256);	/* NEW-FILE-PATH */
      b_WRK_STRING = new CobolDataStorage(250);	/* WRK-STRING */
      b_MD_CURRENT = new CobolDataStorage(250);	/* MD-CURRENT */
      b_MD_PREVIOUS = new CobolDataStorage(250);	/* MD-PREVIOUS */
      b_MD_NEXT = new CobolDataStorage(250);	/* MD-NEXT */
      b_END_FLG = new CobolDataStorage(1);	/* END-FLG */
      b_NEW_REC = b_NEWFILE_record;
      b_OLD_REC = b_OLDFILE_record;

      /* End of data storage */


      initAttr();

      /* Fields */

      /* PROGRAM-ID : AUTOMANUAL */
      f_OLDFILE_record	= CobolFieldFactory.makeCobolField(50000, b_OLDFILE_record, a_1);	/* OLDFILE_record */
      f_NEW_REC	= CobolFieldFactory.makeCobolField(50000, b_NEW_REC, a_1);	/* NEW-REC */
      f_NEWFILE_record	= CobolFieldFactory.makeCobolField(50000, b_NEWFILE_record, a_1);	/* NEWFILE_record */
      f_OLD_STS	= CobolFieldFactory.makeCobolField(2, b_OLD_STS, a_1);	/* OLD-STS */
      f_NEW_STS	= CobolFieldFactory.makeCobolField(2, b_NEW_STS, a_1);	/* NEW-STS */
      f_OLD_FILE_PATH	= CobolFieldFactory.makeCobolField(256, b_OLD_FILE_PATH, a_1);	/* OLD-FILE-PATH */
      f_NEW_FILE_PATH	= CobolFieldFactory.makeCobolField(256, b_NEW_FILE_PATH, a_1);	/* NEW-FILE-PATH */
      f_WRK_STRING	= CobolFieldFactory.makeCobolField(250, b_WRK_STRING, a_1);	/* WRK-STRING */
      f_MD_CURRENT	= CobolFieldFactory.makeCobolField(250, b_MD_CURRENT, a_1);	/* MD-CURRENT */
      f_MD_PREVIOUS	= CobolFieldFactory.makeCobolField(250, b_MD_PREVIOUS, a_1);	/* MD-PREVIOUS */
      f_MD_NEXT	= CobolFieldFactory.makeCobolField(250, b_MD_NEXT, a_1);	/* MD-NEXT */

      /* End of fields */


      /* Constants */

      c_1_none	= CobolFieldFactory.makeCobolField(4, str_0_none, a_1);
      c_2_old	= CobolFieldFactory.makeCobolField(4, str_1_old, a_1);
      c_3_new	= CobolFieldFactory.makeCobolField(4, str_2_new, a_1);
      c_4	= CobolFieldFactory.makeCobolField(18, str_3, a_1);
      c_5	= CobolFieldFactory.makeCobolField(1, str_4, a_1);
      c_6	= CobolFieldFactory.makeCobolField(6, str_5, a_1);
      c_7	= CobolFieldFactory.makeCobolField(2, str_6, a_1);
      c_8	= CobolFieldFactory.makeCobolField(3, str_7, a_1);
      c_9	= CobolFieldFactory.makeCobolField(6, str_8, a_1);
      c_10_https	= CobolFieldFactory.makeCobolField(43, str_9_https, a_1);
      c_11_github	= CobolFieldFactory.makeCobolField(27, str_10_github, a_1);
      c_12	= CobolFieldFactory.makeCobolField(6, str_11, a_1);
      c_13	= CobolFieldFactory.makeCobolField(1, str_12, a_1);
      c_14	= CobolFieldFactory.makeCobolField(2, str_13, a_1);
      c_15	= CobolFieldFactory.makeCobolField(2, str_14, a_1);
      c_16	= CobolFieldFactory.makeCobolField(16, str_15, a_1);
      c_17	= CobolFieldFactory.makeCobolField(18, str_16, a_1);
      c_18	= CobolFieldFactory.makeCobolField(21, str_17, a_1);
      c_19	= CobolFieldFactory.makeCobolField(16, str_18, a_1);

    } catch(NullPointerException e) {
      System.out.println("Error - NullpointerException");
    } catch(IndexOutOfBoundsException e) {
      System.out.println("Error - IndexOutOfBoundsException");
    }
  }

  private void initAttr() {
    /* Attributes */

    a_1 = new CobolFieldAttribute (33, 0, 0, 0, null);

  }

  /* Data storage */

  /* PROGRAM-ID : AUTOMANUAL */
  private CobolDataStorage b_RETURN_CODE;	/* RETURN-CODE */
  private CobolDataStorage b_OLDFILE_record;	/* OLDFILE_record */
  private CobolDataStorage b_NEWFILE_record;	/* NEWFILE_record */
  private CobolDataStorage b_OLD_STS;	/* OLD-STS */
  private CobolDataStorage b_NEW_STS;	/* NEW-STS */
  private CobolDataStorage b_OLD_FILE_PATH;	/* OLD-FILE-PATH */
  private CobolDataStorage b_NEW_FILE_PATH;	/* NEW-FILE-PATH */
  private CobolDataStorage b_WRK_STRING;	/* WRK-STRING */
  private CobolDataStorage b_MD_CURRENT;	/* MD-CURRENT */
  private CobolDataStorage b_MD_PREVIOUS;	/* MD-PREVIOUS */
  private CobolDataStorage b_MD_NEXT;	/* MD-NEXT */
  private CobolDataStorage b_END_FLG;	/* END-FLG */
  private CobolDataStorage b_NEW_REC;
  private CobolDataStorage b_OLD_REC;

  /* End of data storage */


  /* Fields */

  /* PROGRAM-ID : AUTOMANUAL */
  private AbstractCobolField f_OLDFILE_record;	/* OLDFILE_record */
  private AbstractCobolField f_NEW_REC;	/* NEW-REC */
  private AbstractCobolField f_NEWFILE_record;	/* NEWFILE_record */
  private AbstractCobolField f_OLD_STS;	/* OLD-STS */
  private AbstractCobolField f_NEW_STS;	/* NEW-STS */
  private AbstractCobolField f_OLD_FILE_PATH;	/* OLD-FILE-PATH */
  private AbstractCobolField f_NEW_FILE_PATH;	/* NEW-FILE-PATH */
  private AbstractCobolField f_WRK_STRING;	/* WRK-STRING */
  private AbstractCobolField f_MD_CURRENT;	/* MD-CURRENT */
  private AbstractCobolField f_MD_PREVIOUS;	/* MD-PREVIOUS */
  private AbstractCobolField f_MD_NEXT;	/* MD-NEXT */

  /* End of fields */


  private static AbstractCobolField f_native;

  /* Constants */

  private AbstractCobolField c_19;
  private AbstractCobolField c_18;
  private AbstractCobolField c_17;
  private AbstractCobolField c_16;
  private AbstractCobolField c_15;
  private AbstractCobolField c_14;
  private AbstractCobolField c_13;
  private AbstractCobolField c_12;
  private AbstractCobolField c_11_github;
  private AbstractCobolField c_10_https;
  private AbstractCobolField c_9;
  private AbstractCobolField c_8;
  private AbstractCobolField c_7;
  private AbstractCobolField c_6;
  private AbstractCobolField c_5;
  private AbstractCobolField c_4;
  private AbstractCobolField c_3_new;
  private AbstractCobolField c_2_old;
  private AbstractCobolField c_1_none;

  /* Attributes */

  private CobolFieldAttribute a_1;



  /* String literals */
  public static final byte[] str_18 = CobolUtil.stringToBytes("<!--navi end2-->");
  public static final byte[] str_17 = CobolUtil.toBytes((byte)0xe3, (byte)0x83, (byte)0x9a, (byte)0xe3, (byte)0x83, (byte)0xbc, (byte)0xe3, (byte)0x82, (byte)0xb8, (byte)0xe3, (byte)0x83, (byte)0x88, (byte)0xe3, (byte)0x83, (byte)0x83, (byte)0xe3, (byte)0x83, (byte)0x97, (byte)0xe3, (byte)0x81, (byte)0xb8);
  public static final byte[] str_16 = CobolUtil.stringToBytes("<!--navi start2-->");
  public static final byte[] str_15 = CobolUtil.stringToBytes("<!--navi end1-->");
  public static final byte[] str_14 = CobolUtil.stringToBytes(")/");
  public static final byte[] str_13 = CobolUtil.stringToBytes("/[");
  public static final byte[] str_12 = CobolUtil.stringToBytes(")");
  public static final byte[] str_11 = CobolUtil.toBytes((byte)0xe6, (byte)0xac, (byte)0xa1, (byte)0xe3, (byte)0x81, (byte)0xb8);
  public static final byte[] str_10_github = CobolUtil.stringToBytes("github.io/markdown/TOC.html");
  public static final byte[] str_9_https = CobolUtil.stringToBytes("https://momo2584.github.io/opensourcecobol.");
  public static final byte[] str_8 = CobolUtil.toBytes((byte)0xe7, (byte)0x9b, (byte)0xae, (byte)0xe6, (byte)0xac, (byte)0xa1);
  public static final byte[] str_7 = CobolUtil.stringToBytes(")/[");
  public static final byte[] str_6 = CobolUtil.stringToBytes("](");
  public static final byte[] str_5 = CobolUtil.toBytes((byte)0xe5, (byte)0x89, (byte)0x8d, (byte)0xe3, (byte)0x81, (byte)0xb8);
  public static final byte[] str_4 = CobolUtil.stringToBytes("[");
  public static final byte[] str_3 = CobolUtil.stringToBytes("<!--navi start1-->");
  public static final byte[] str_2_new = CobolUtil.stringToBytes("new/");
  public static final byte[] str_1_old = CobolUtil.stringToBytes("old/");
  public static final byte[] str_0_none = CobolUtil.stringToBytes("none");
  /* File OLDFILE */
  private CobolFile		h_OLDFILE = null;
  private byte[]	h_OLDFILE_status = new byte[4];
  /* File NEWFILE */
  private CobolFile		h_NEWFILE = null;
  private byte[]	h_NEWFILE_status = new byte[4];

  /* Sections and Labels */
  private final static int l_AUTOMANUAL = 1;
  private final static int l_MAIN_CONTROL = 2;
  private final static int l_MAIN_CONTROL__MAIN_000 = 3;
  private final static int l_MAIN_CONTROL__MAIN_900 = 4;
  private final static int l_Default_Error_Handler = 5;

}
