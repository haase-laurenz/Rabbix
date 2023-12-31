    package com.example.RegisterLogin.Service;

    import java.util.ArrayList;
    import java.util.List;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.scheduling.annotation.Async;
    import org.springframework.stereotype.Service;

    import com.example.RegisterLogin.Entity.Account;
    import com.example.RegisterLogin.Entity.Block;
    import com.example.RegisterLogin.Entity.Transaction;
    import com.example.RegisterLogin.Repo.BlockRepo;

    @Service
    public class BlockchainService {
        
        @Autowired
        private BlockRepo blockRepo;

        @Autowired 
        private AccountService accountService;

        private volatile boolean miningInterrupted;

        private Account activeAccount;

        public BlockchainService(BlockRepo blockRepo, AccountService accountService) {
            this.blockRepo = blockRepo;
            this.accountService = accountService;
            this.miningInterrupted = false;
        }

        

        public List<Block> findAllBlocks(){
            return blockRepo.findAll();
        }

        @Async
        public void mine() {
            setMiningStatus(true);
            while (miningInterrupted) {
                Block block = new Block(0, getLastHash(), new ArrayList<Transaction>(), getHeight());
                block.mine();
                saveBlock(block);
                setMiningRewards();
                
            }
        }

        public void interruptMining() {
            setMiningStatus(false);
        }
        
        
        public void saveBlock(Block block){
            if (block.getOwnHash()!=null){
                blockRepo.save(block);
                if (!isValid()){
                    System.out.println("Illiagal Block found");
                    blockRepo.delete(block);
                }
            }else{
                System.out.println("No hash generated");
            }
            
        }

        public void generateGenesisBlock(){
            Block block = new Block(0, "0000000000000000000000000000000000000000000000000000000000000000", new ArrayList<Transaction>(),0);
            block.mine();
            if (block.getOwnHash()!=null){
                blockRepo.save(block);
            }
            System.out.println("Genesis Block generated");
        }

        public int getHeight(){
            return blockRepo.findAll().size();
        }

        public String getLastHash() {
            List<Block> blocks = blockRepo.findAllByOrderByIdDesc();

            if (!blocks.isEmpty()) {
                Block lastBlock = blocks.get(0);
                return lastBlock.getOwnHash();
            } else {
                // Handle the case when there are no blocks in the database
                return null; // or throw an exception or return a default value
            }
        }

        public boolean getMiningStatus(){
            return this.miningInterrupted;
        }

        public boolean isValid(){
            List<Block> blocks = blockRepo.findAll();
            for (int i = 1; i < blocks.size(); i++) {
                Block currentBlock = blocks.get(i);
                Block previousBlock = blocks.get(i - 1);

                if (!previousBlock.getOwnHash().equals(currentBlock.getPrevHash())) {
                    System.out.println("Previous Hashes not equal: "+i);
                    return false;
                }
            }
            System.out.println("Valid Blockchain");
            return true;
        }

        private synchronized void setMiningStatus(boolean status) {
            this.miningInterrupted = status;
        }



        public void setActiveAccount(Account account) {
            this.activeAccount = account;
        }

        public synchronized void setMiningRewards(){
            activeAccount.setRabbixCoinsTotal(activeAccount.getRabbixCoinsTotal()+10);
            activeAccount.setRabbixCoinsMined(activeAccount.getRabbixCoinsMined()+10);
            activeAccount.setBlocksMined(activeAccount.getBlocksMined()+1);
            accountService.save(activeAccount);
            
        }   

    }
